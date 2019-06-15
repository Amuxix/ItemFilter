package me.amuxix.categories.manual.leagues

import cats.data.NonEmptyList
import me.amuxix.{Block, FilterLevel}
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition

import scala.concurrent.Future

object Legacy extends Category {
  val leaguestones = Block(Condition(`class` = "Leaguestone"), Action(size = 45, textColor = Color.black, backgroundColor = Color.legacyBlue))

  override def categoryBlocks: FilterLevel => Future[NonEmptyList[Block]] = { _ =>
    Future.successful(NonEmptyList.one(leaguestones))
  }
}
