package me.amuxix.categories.semiautomated.recipes

import cats.data.NonEmptyList
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions._
import me.amuxix.items.{GenericItem, Value}
import me.amuxix.providers.Provider

object Chisel extends SemiAutomatedCategory {
  private val hammers = Seq("Gavel", "Rock Breaker", "Stone Hammer")

  override protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = NonEmptyList.fromListUnsafe {
    (for {
      chisel <- provider.currencies.getByName("Cartographer's Chisel")
      whetstone <- provider.currencies.getByName("Blacksmith's Whetstone")
    } yield {
      lazy val hammerValuePerSlot = chisel.chaosValuePerSlot(provider).map(_ / 6) //The area of a hammer
      lazy val whetstoneValue = whetstone.chaosValuePerSlot(provider)

      def generateGenericItem(whetstonesRequired: Int, gameRarity: GameRarity) = {
        val quality: Option[Quality] = gameRarity match {
          case Magic => (0, 20 - 2 * whetstonesRequired)
          case _     => (0, 20 - 5 * whetstonesRequired)
        }
        new GenericItem with Value {
          override def chaosValuePerSlot(
            provider: Provider
          ): Option[Double] = for {
            chisel <- hammerValuePerSlot
            whetstone <- whetstoneValue
          } yield chisel - whetstone * whetstonesRequired

          override lazy val condition: Condition = Condition(base = hammers, rarity = Some(Rarity(gameRarity)), quality = quality)
        }
      }

      val whites = (1 to 4).map(generateGenericItem(_, Normal))
      val blues = (1 to 10).map(generateGenericItem(_, Magic))

      whites ++ blues :+ new GenericItem with Value {
        override def chaosValuePerSlot(provider: Provider): Option[Double] = hammerValuePerSlot

        override lazy val condition: Condition = Condition(base = hammers, quality = 20)
      }
    }).toList.flatten
  }

  override protected def actionForRarity: FilterRarity => Action = _ => Action()
}
