package me.amuxix.categories.manual.leagues

import cats.data.NonEmptyList
import me.amuxix.{Block, FilterLevel}
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.providers.Provider

object Legacy extends Category {
  private val leaguestones = Block(Condition(`class` = "Leaguestone"), Action(size = 45, textColor = Color.black, backgroundColor = Color.legacyBlue))

  override def categoryBlocks(provider: Provider): FilterLevel => NonEmptyList[Block] = _ => NonEmptyList.one(leaguestones)
}
