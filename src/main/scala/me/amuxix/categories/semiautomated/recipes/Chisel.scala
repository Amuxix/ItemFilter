package me.amuxix.categories.semiautomated.recipes

import cats.data.{NonEmptyList, OptionT}
import cats.effect.IO
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions._
import me.amuxix.database.Currencies
import me.amuxix.items.{GenericItem, Price}

object Chisel extends SemiAutomatedCategory {
  private val hammers = Seq("Gavel", "Rock Breaker", "Stone Hammer")
  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    (for {
      chisel <- Currencies.getByName("Cartographer's Chisel")
      whetstone <- Currencies.getByName("Blacksmith's Whetstone")
    } yield {
      def hammerValuePerSlot(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]) = chisel.chaosValuePerSlot(prices, parentLeaguePrices).map(_ / 6) //The area of a hammer
      def whetstoneValue(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]) = whetstone.chaosValuePerSlot(prices, parentLeaguePrices)

      def generateGenericItem(whetstonesRequired: Int, gameRarity: GameRarity) = {
        val quality: Option[Quality] = gameRarity match {
          case Magic => (0, 20 - 2 * whetstonesRequired)
          case _     => (0, 20 - 5 * whetstonesRequired)
        }
        val cond: Condition = Condition(base = hammers, rarity = Some(Rarity(gameRarity)), quality = quality)
        new GenericItem with Price {
          override def chaosValuePerSlot(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]): OptionT[IO, Double] = for {
            chisel <- hammerValuePerSlot(prices, parentLeaguePrices)
            whetstone <- whetstoneValue(prices, parentLeaguePrices)
          } yield chisel - whetstone * whetstonesRequired
          override lazy val condition: IO[Condition] =
            IO.pure(cond)
        }
      }

      val whites = (1 to 4).map(generateGenericItem(_, Normal))
      val blues = (1 to 10).map(generateGenericItem(_, Magic))

      whites ++ blues :+ new GenericItem with Price {
        override def chaosValuePerSlot(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]): OptionT[IO, Double] =
          hammerValuePerSlot(prices, parentLeaguePrices)
        override lazy val condition: IO[Condition] =
          IO.pure(Condition(base = hammers, quality = 20))
      }
    }).value.map(hammers => NonEmptyList.fromListUnsafe(hammers.toList.flatten))

  override protected def actionForRarity: FilterRarity => Action = { _ =>
    Action()
  }
}
