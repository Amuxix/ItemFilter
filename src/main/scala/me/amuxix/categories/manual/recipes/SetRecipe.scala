package me.amuxix.categories.manual.recipes

import cats.data.NonEmptyList
import me.amuxix.{Block, FilterLevel, Reduced}
import me.amuxix.ItemFilter._
import me.amuxix.actions.{Action, Color}
import me.amuxix.actions.Color.black
import me.amuxix.categories.Category
import me.amuxix.conditions._

import scala.concurrent.Future

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

  private val weapons = Block(partialCondition(None, 1, 3, dropLevel = Some((cutoffs.setArmourDropLevel * 1.5).toInt)), equipmentAction)
  private val smallBows = Block(partialCondition(Seq("Bows"), 2, 3), equipmentAction)
  private val armor = Block(partialCondition(config.armourClasses, dropLevel = Some(cutoffs.setArmourDropLevel)), equipmentAction)
  private val accessories = Block(
    partialCondition(config.accessoriesClasses),
    Action(
      size = 37,
      textColor = color.lighten,
      borderColor = color.darken,
      backgroundColor = black
    )
  )

  override def categoryBlocks: FilterLevel => Future[NonEmptyList[Block]] = {
    case Reduced => Future.successful(NonEmptyList(accessories, List(weapons.hidden, smallBows.hidden, armor.hidden)))
    case _       => Future.successful(NonEmptyList(accessories, List(weapons, smallBows, armor)))
  }
}
