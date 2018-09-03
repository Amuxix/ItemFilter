package me.amuxix.categories.leagues

import me.amuxix.actions.Color._
import me.amuxix.actions.{Action, Blue, Circle}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

object Delve extends Category {
  val fossils = Block(
    Condition(base = "Fossil", `class` = "Currency"),
    Action(
      size = 40,
      borderColor = legacyBlue,
      textColor = legacyBlue,
      backgroundColor = delveBlue,
      minimapIcon = (Blue, Circle),
    )
  )
  //Resonator
  val resonators = Block(
    Condition(base = "Resonator", `class` = "Currency"),
    Action(
      size = 40,
      borderColor = legacyBlue,
      textColor = legacyBlue,
      backgroundColor = delveBlue,
      minimapIcon = (Blue, Circle),
    )
  )

  override protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = Seq(fossils, resonators)
}
