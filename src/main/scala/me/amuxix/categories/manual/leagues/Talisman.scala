package me.amuxix.categories.manual.leagues

import cats.data.NonEmptyList
import me.amuxix.{Block, FilterLevel}
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition

import scala.concurrent.Future

object Talisman extends Category {

  val talismans =
    Block(Condition(base = "Talisman"), Action(borderColor = Color.pink))

  override def categoryBlocks: FilterLevel => Future[NonEmptyList[Block]] = { _ =>
    Future.successful(NonEmptyList.one(talismans))
  }
}
