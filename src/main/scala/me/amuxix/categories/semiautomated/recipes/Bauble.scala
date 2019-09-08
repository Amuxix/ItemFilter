package me.amuxix.categories.semiautomated.recipes

import cats.data.{NonEmptyList, OptionT}
import cats.effect.IO
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.database.Currencies
import me.amuxix.items.{GenericItem, Price}

import scala.Predef.{Map => ScalaMap}

object Bauble extends SemiAutomatedCategory {
  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    Currencies
      .getByName("Glassblower's Bauble")
      .value
      .map(_.toList.flatMap { glassblowersBauble =>
        def generateGenericItem(quality: Int): GenericItem = {
          new GenericItem with Price {
            override def chaosValuePerSlot(prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): OptionT[IO, Double] =
              glassblowersBauble.chaosValuePerSlot(prices, parentLeaguePrices).map(value => (value / 2) / (40 / quality))
            override lazy val condition: IO[Condition] =
              IO.pure(Condition(`class` = "Flask", quality = quality))
          }
        }

        List.range(1, 19).map(generateGenericItem) :+
          new GenericItem with Price {
            override def chaosValuePerSlot(prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): OptionT[IO, Double] =
              glassblowersBauble.chaosValuePerSlot(prices, parentLeaguePrices).map(_ / 2)
            override lazy val condition: IO[Condition] =
              IO.pure(Condition(`class` = "Flask", quality = 20))
          }
      })
      .map(NonEmptyList.fromListUnsafe)

  override protected def actionForRarity: FilterRarity => Action = { _ =>
    Action()
  }
}
