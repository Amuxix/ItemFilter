package me.amuxix.categories.semiautomated

import cats.data.{NonEmptyList, OptionT}
import cats.implicits._
import me.amuxix._
import me.amuxix.ItemFilter.{ec, _}
import me.amuxix.actions.{Action, Green, Sound}
import me.amuxix.actions.Color.{darkRed, goodYellow, red, white}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Magic, Normal, Rare => GameRare}
import me.amuxix.database.{Bases, Currencies}
import me.amuxix.items.{GenericItem, Value}

import scala.concurrent.Future

object General extends SemiAutomatedCategory {
  private val itemClasses = config.accessoriesClasses ++ config.armourClasses ++ config.weaponClasses ++ config.shieldClasses

  override protected lazy val categoryItems: Future[NonEmptyList[GenericItem]] =
    for {
      bestItems <- Bases.bestItems
      allEquipment <- Bases.allEquipment
    } yield {
      val general = NonEmptyList.of(
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(AlwaysShow)
          override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = Seq("Quest Items", "Labyrinth Item", "Pantheon Soul", "Labyrinth Trinket")))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Mythic)
          override lazy val condition: Future[Condition] = Future.successful(Condition(base = "Albino Rhoa Feather"))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Mythic)
          override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Fishing Rod"))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Mythic)
          override lazy val condition: Future[Condition] = Future.successful(Condition(linkedSockets = 6))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Epic)
          override lazy val condition: Future[Condition] = Future.successful(Condition(linkedSockets = 5))
        },
        new GenericItem with Value {
          override def chaosValuePerSlot: OptionT[Future, Double] =
            for {
              jew <- Currencies.getByName("Jeweller's Orb")
              sixSocketValue <- jew.chaosValuePerSlot.map(_ * 7)
            } yield sixSocketValue
          override lazy val condition: Future[Condition] = Future.successful(Condition(sockets = 6))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(itemLevel = (1, cutoffs.normalItems), linkedSockets = 3))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(itemLevel = (1, cutoffs.magicItems), linkedSockets = 4))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(itemLevel = (1, cutoffs.fourLinkRare), linkedSockets = 4, rarity = GameRare))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = "Belt", itemLevel = (1, cutoffs.normalItems)))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = itemClasses, itemLevel = (1, cutoffs.normalItems), rarity = Normal))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = itemClasses, itemLevel = (1, cutoffs.magicItems), rarity = Magic))
        },
        new GenericItem {
          override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          override lazy val condition: Future[Condition] = Future.successful(Condition(`class` = config.accessoriesClasses, rarity = GameRare, itemLevel = (1, 60)))
        },
      )
      val best = bestItems.flatMap { i =>
        NonEmptyList.of(
          new GenericItem {
            override lazy val rarity: Future[FilterRarity] = Future.successful(Undetermined)
            override lazy val condition: Future[Condition] = i.rare
          },
          new GenericItem {
            override lazy val rarity: Future[FilterRarity] = Future.successful(AlwaysHide)
            override lazy val condition: Future[Condition] = i.crafting
          }
        )
      }
      val all = allEquipment.flatMap { i =>
        NonEmptyList.of(
          new GenericItem {
            override lazy val condition: Future[Condition] = i.conditionsOfBestRaresForZoneLevel
            override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          },
            new GenericItem {
            override lazy val condition: Future[Condition] = i.conditionsOfGoodRaresForZoneLevel
            override lazy val rarity: Future[FilterRarity] = Future.successful(Leveling)
          },
            new GenericItem {
            override lazy val condition: Future[Condition] = i.conditionsOfBestWhitesForZoneLevel
            override lazy val rarity: Future[FilterRarity] = Future.successful(AlwaysHide)
          },
        )
      }

      general concatNel best concatNel all
    }

  override protected def actionForRarity: FilterRarity => Action = {
    case AlwaysHide =>
      Action()
    case AlwaysShow =>
      Action(size = 45, beam = Green)
    case Undetermined =>
      Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow)
    case Leveling =>
      Action(size = 45, borderColor = white)
    case Mythic =>
      Action(size = 45, sound = Sound.myths, borderColor = red, backgroundColor = white, textColor = red)
    case _ => //5Linkeds and 6 sockets
      Action(size = 45, sound = Sound.epic, borderColor = red)
  }
}
