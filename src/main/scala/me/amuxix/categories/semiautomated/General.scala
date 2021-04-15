package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions.{Action, Green, Sound}
import me.amuxix.actions.Color.{darkRed, goodYellow, red, white}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.{GenericItem, Value}
import me.amuxix.providers.Provider

object General extends SemiAutomatedCategory {
  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = {
      val general = NonEmptyList.of(
        new GenericItem {
          override def rarity(provider: Provider): FilterRarity = AlwaysShow
          override lazy val condition: Condition = Condition(`class` = Seq("Quest Items", "Labyrinth Item", "Pantheon Soul", "Labyrinth Trinket"))
        },
        new GenericItem {
          override def rarity(provider: Provider): FilterRarity = Mythic
          override lazy val condition: Condition = Condition(base = "Albino Rhoa Feather")
        },
        new GenericItem {
          override def rarity(provider: Provider): FilterRarity = Mythic
          override lazy val condition: Condition = Condition(`class` = "Fishing Rod")
        },
        new GenericItem {
          override def rarity(provider: Provider): FilterRarity = Mythic
          override lazy val condition: Condition = Condition(linkedSockets = 6)
        },
        new GenericItem {
          override def rarity(provider: Provider): FilterRarity = Epic
          override lazy val condition: Condition = Condition(linkedSockets = 5)
        },
        new GenericItem with Value {
          override def chaosValuePerSlot(provider: Provider): Option[Double] =
            for {
              jew <- provider.currencies.getByName("Jeweller's Orb")
              sixSocketValue <- jew.chaosValuePerSlot(provider).map(_ * 7)
            } yield sixSocketValue
          override lazy val condition: Condition = Condition(sockets = 6)
        },
      )
      val crafting = provider.bases.bestItems.flatMap { i =>
        NonEmptyList.of(
          new GenericItem {
            override def rarity(provider: Provider): FilterRarity = AlwaysHide
            override lazy val condition: Condition = i.crafting
          }
        )
      }
      general concatNel crafting
    }

  override protected def actionForRarity: FilterRarity => Action = {
    case AlwaysHide =>
      Action()
    case AlwaysShow =>
      Action(size = 45, beam = Green)
    case Undetermined =>
      Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow)
    case Mythic =>
      Action(size = 45, sound = Sound.myths, borderColor = red, backgroundColor = white, textColor = red)
    case _ => //5Linkeds and 6 sockets
      Action(size = 45, sound = Sound.epic, borderColor = red)
  }
}
