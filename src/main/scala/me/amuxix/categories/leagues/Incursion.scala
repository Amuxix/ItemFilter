package me.amuxix.categories.leagues

import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

object Incursion extends Category {
  private val action = Action(size = 45, backgroundColor = Color.black, textColor = Color.incursionRed, borderColor = Color.incursionGreen, sound = Sound.incursion)

  val items = Block(
    Condition(
      `class` = "Incursion Item",
    ),
    action
  )

  val vials = Block(
    Condition(
      base = "Vial of",
      `class` = "Currency",
    ),
    action
  )

  override protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = Seq(items, vials)
}
