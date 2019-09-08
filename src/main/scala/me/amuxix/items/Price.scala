package me.amuxix.items
import cats.data.OptionT
import cats.effect.IO
import me.amuxix._
import me.amuxix.FilterRarity.Priced._
import me.amuxix.FilterRarity.Undetermined
import me.amuxix.conditions.Condition

import scala.Predef.{Map => ScalaMap}

trait Price extends Rarity {
  def chaosValuePerSlot(prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): OptionT[IO, Double]

  final override def rarity(prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): IO[FilterRarity] =
    chaosValuePerSlot(prices, parentLeaguePrices).fold[FilterRarity](Undetermined) { chaosValuePerSlot =>
      if (chaosValuePerSlot >= Mythic.threshold) Mythic
      else if (chaosValuePerSlot >= Epic.threshold) Epic
      else if (chaosValuePerSlot >= Rare.threshold) Rare
      else if (chaosValuePerSlot >= Uncommon.threshold) Uncommon
      else if (chaosValuePerSlot >= Common.threshold) Common
      else Leveling //The price is lower than the lowest threshold.
    }
}

object Price {
  def apply(valueT: OptionT[IO, Double], cond: Condition): GenericItem =
    new GenericItem with Price {
      override def chaosValuePerSlot(prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): OptionT[IO, Double] = valueT
      override lazy val condition: IO[Condition] = IO.pure(cond)
    }
}
