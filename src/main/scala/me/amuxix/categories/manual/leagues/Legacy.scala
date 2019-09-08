package me.amuxix.categories.manual.leagues

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.{Block, FilterLevel}
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition

object Legacy extends Category {
  val leaguestones = Block(Condition(`class` = "Leaguestone"), Action(size = 45, textColor = Color.black, backgroundColor = Color.legacyBlue))

  override def categoryBlocks(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]): FilterLevel => IO[NonEmptyList[Block]] = { _ =>
    IO.pure(NonEmptyList.one(leaguestones))
  }
}
