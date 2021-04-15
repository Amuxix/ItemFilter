package me.amuxix.categories.manual.leagues

import cats.data.NonEmptyList
import me.amuxix.{Block, FilterLevel}
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.providers.Provider

object Talisman extends Category {

  private val talismans = Block(Condition(base = "Talisman"), Action(borderColor = Color.pink))

  override def categoryBlocks(provider: Provider): FilterLevel => NonEmptyList[Block] = _ => NonEmptyList.one(talismans)
}
