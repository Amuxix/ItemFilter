package me.amuxix.items
import cats.effect.IO
import me.amuxix.{Block, FilterRarity}
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition

import scala.Predef.{Map => ScalaMap}

abstract class GenericItem extends Rarity {
  def condition: IO[Condition]

  def block(actionForRarity: FilterRarity => Action, prices: ScalaMap[String, Double], parentLeaguePrices: ScalaMap[String, Double]): IO[Block] =
    for {
      rarity <- rarity(prices, parentLeaguePrices)
      condition <- condition
    } yield Block(condition, actionForRarity(rarity), rarity)
}

object GenericItem {
  def apply(r: FilterRarity, cond: IO[Condition]): GenericItem =
    new GenericItem with PureRarity {
      override val rarity: FilterRarity = r
      override lazy val condition: IO[Condition] = cond
    }

  def apply(r: FilterRarity, cond: Condition): GenericItem =
    new GenericItem with PureRarity {
      override val rarity: FilterRarity = r
      override lazy val condition: IO[Condition] = IO.pure(cond)
    }
}
