package me.amuxix.categories.semiautomated

import cats.data.{NonEmptyList, OptionT}
import cats.effect.IO
import me.amuxix.FilterRarity
import me.amuxix.actions.{Action, Sound}
import me.amuxix.actions.Color.{darkRed, goodYellow, red, white}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.database.{Bases, Currencies}
import me.amuxix.items.{GenericItem, Price}
import me.amuxix.FilterRarity.{AlwaysHide, AlwaysShow, Undetermined}
import me.amuxix.FilterRarity.Priced.{Epic, Mythic}
import me.amuxix.actions.EffectColor.Green

import scala.Predef.{Map => ScalaMap}

object General extends SemiAutomatedCategory {
  override protected lazy val categoryItems: IO[NonEmptyList[GenericItem]] =
    Bases.bestItems.map { bestItems =>
      val general = NonEmptyList.of(
        GenericItem(AlwaysShow, Condition(`class` = Seq("Quest Items", "Labyrinth Item", "Pantheon Soul", "Labyrinth Trinket"))),
        GenericItem(Mythic, Condition(base = "Albino Rhoa Feather")),
        GenericItem(Mythic, Condition(`class` = "Fishing Rod")),
        GenericItem(Mythic, Condition(linkedSockets = 6)),
        GenericItem(Epic, Condition(linkedSockets = 5)),
        new GenericItem with Price {
          override def chaosValuePerSlot(prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): OptionT[IO, Double] =
            for {
              jew <- Currencies.getByName("Jeweller's Orb")
              sixSocketValue <- jew.chaosValuePerSlot(prices, parentLeaguePrices).map(_ * 7)
            } yield sixSocketValue
          override lazy val condition: IO[Condition] = IO.pure(Condition(sockets = 6))
        },
      )
      val best = bestItems.flatMap { i =>
        NonEmptyList.of(
          GenericItem(Undetermined, i.rare),
          GenericItem(AlwaysHide, i.crafting),
        )
      }
      general concatNel best
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
