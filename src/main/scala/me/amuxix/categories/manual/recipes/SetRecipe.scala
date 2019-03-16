package me.amuxix.categories.manual.recipes

import me.amuxix.ItemFilter._
import me.amuxix.actions.Color.black
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions._
import me.amuxix.{Block, FilterLevel, Reduced}

abstract class SetRecipe(minItemLevel: Int, color: Color) extends Category {
  private val equipmentAction = Action(size = 34, textColor = color, borderColor = color, backgroundColor = black)
  private def partialCondition(`class`: Option[ItemClass], width: Option[Width] = None, height: Option[Height] = None, dropLevel: Option[Int] = None) =
      Condition(
        `class` = `class`,
        width = width,
        height = height,
        itemLevel = (minItemLevel, 100),
        rarity = Rare,
        identified = false,
        dropLevel = dropLevel.map(i => DropLevel(1, i))
    )

  private val weapons = Block(partialCondition(None, 1, 3), equipmentAction)
  private val smallBows = Block(partialCondition(Seq("Bows"), 2, 3), equipmentAction)
  private val armor = Block(partialCondition(config.armourClasses, dropLevel = Some(cutoffs.setArmourDropLevel)), equipmentAction)
  private val accessories = Block(
    partialCondition(config.accessoriesClasses),
    Action(size = 37, textColor = color.lighten, borderColor = color.darken, backgroundColor = black)
  )

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => Seq(accessories, weapons.hidden, smallBows.hidden, armor.hidden)
    case _       => Seq(accessories, weapons, smallBows, armor)
  }
}
