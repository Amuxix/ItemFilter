package me.amuxix.categories.manual.leagues

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.{Block, FilterLevel}
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition

object Talisman extends Category {

  val talismans =
    Block(Condition(base = "Talisman"), Action(borderColor = Color.pink))

  override def categoryBlocks(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]): FilterLevel => IO[NonEmptyList[Block]] = { _ =>
    IO.pure(NonEmptyList.one(talismans))
  }
}
