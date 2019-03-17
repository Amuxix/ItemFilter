package me.amuxix.categories.semiautomated.recipes

import cats.data.{NonEmptyList, OptionT}
import cats.implicits._
import me.amuxix.FilterRarity
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions._
import me.amuxix.database.Currencies
import me.amuxix.items.GenItem

import scala.concurrent.Future

object Chisel extends SemiAutomatedCategory {
  private val hammers = Seq("Gavel", "Rock Breaker", "Stone Hammer")
  override protected val categoryItems: Future[NonEmptyList[GenItem]] =
    (for {
      chisel <- Currencies.getByName("Cartographer's Chisel")
      whetstone <- Currencies.getByName("Blacksmith's Whetstone")
    } yield {
      lazy val hammerValuePerSlot = chisel.chaosValuePerSlot.map(_ / 6) //The area of a hammer
      lazy val whetstoneValue = whetstone.chaosValuePerSlot

      def generateGenericItem(whetstonesRequired: Int, gameRarity: GameRarity) = {
        val quality: Option[Quality] = gameRarity match {
          case Magic => (0, 20 - 2 * whetstonesRequired)
          case _     => (0, 20 - 5 * whetstonesRequired)
        }
        val cond: Condition = Condition(base = hammers, rarity = Some(Rarity(gameRarity)), quality = quality)
        new GenItem {
          override lazy val chaosValuePerSlot: OptionT[Future, Double] = for {
            chisel <- hammerValuePerSlot
            whetstone <- whetstoneValue
          } yield chisel - whetstone * whetstonesRequired
          override lazy val condition: Condition = cond
        }
      }

      val whites = (1 to 4).map(generateGenericItem(_, Normal))
      val blues = (1 to 10).map(generateGenericItem(_, Magic))

      whites ++ blues :+ new GenItem {
        override def chaosValuePerSlot: OptionT[Future, Double] = hammerValuePerSlot
        override def condition: Condition = Condition(base = hammers, quality = 20)
      }
    }).value.map(hammers => NonEmptyList.fromListUnsafe(hammers.toList.flatten))

  override protected def actionForRarity: FilterRarity => Action = { _ =>
    Action()
  }
}
