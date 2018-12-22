package me.amuxix.categories.automated.recipes
import me.amuxix.FilterRarity
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Action
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.conditions._
import me.amuxix.database.Currencies
import me.amuxix.items.GenItem

import scala.concurrent.Future

object Chisel extends AutomatedCategory {
  private val hammers = Seq("Gavel", "Rock Breaker", "Stone Hammer")
  override protected val categoryItems: Future[Seq[GenItem]] =
    for {
      chisel <- Currencies.getByName("Cartographer's Chisel")
      whetstone <- Currencies.getByName("Blacksmith's Whetstone")
    } yield {
      lazy val chaosValue = chisel.chaosValuePerSlot.map(_ / 6) //The area of a hammer

      def generateGenericItem(whetstonesRequired: Int, rarity: GameRarity) = {
        val quality: Option[Quality] = rarity match {
          case Magic => (0, 20 - 2 * whetstonesRequired)
          case _ => (0, 20 - 5 * whetstonesRequired)
        }
        val cond: Condition = Condition(base = hammers, rarity = Some(Rarity(rarity)), quality = quality)
        new GenItem {
          override lazy val chaosValuePerSlot: Option[Double] = for {
            chisel <- chaosValue
            whetstone <- whetstone.chaosValuePerSlot
          } yield chisel - whetstone * whetstonesRequired
          override lazy val condition: Condition = cond
        }
      }

      val whites = (0 to 4).map(generateGenericItem(_, Normal))
      val blues = (0 to 10).map(generateGenericItem(_, Magic))

      whites ++ blues :+ new GenItem {
        override def chaosValuePerSlot: Option[Double] = chaosValue
        override def condition: Condition = Condition(base = hammers, quality = 20)
      }
    }

  override protected def actionForRarity(rarity: FilterRarity): Action = Action()
}
