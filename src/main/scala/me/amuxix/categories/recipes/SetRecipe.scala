package me.amuxix.categories.recipes

import me.amuxix.actions.Color.black
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions._
import me.amuxix.{Block, FilterLevel, Reduced}

abstract class SetRecipe(minItemLevel: Int, color: Color) extends Category {
  private val equipmentAction = Action(size = 34, text = color, border = color, background = black)
  private val partialCondition = (c: Option[ItemClass], w: Option[Width], h: Option[Height]) =>
    Condition(`class` = c, width = w, height = h, itemLevel = (">=", minItemLevel), rarity = Rare, identified = false)

  private val weapons = Block(partialCondition(None, 1, 3), equipmentAction)
  private val armor = Block(partialCondition(Seq("Gloves", "Boots", "Body Armours", "Helmets"), None, None), equipmentAction)
  private val accessories = Block(
    partialCondition(Seq("Rings", "Belts", "Amulets"), None, None),
    Action(size = 37, text = color.lighten, border = color.darken, background = black)
  )

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => Seq(accessories)
    case _ => Seq(weapons, armor, accessories)
  }
}
