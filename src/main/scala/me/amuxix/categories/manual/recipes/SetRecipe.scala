package me.amuxix.categories.manual.recipes

import cats.data.NonEmptyList
import me.amuxix.{Rare => _, _}
import me.amuxix.ItemFilter.settings
import me.amuxix.actions.{Action, Color}
import me.amuxix.actions.Color.black
import me.amuxix.categories.Category
import me.amuxix.conditions.{Rare, Normal => _, _}

import scala.concurrent.Future

abstract class SetRecipe(minItemLevel: Int, color: Color) extends Category {
  private val equipmentAction = Action(size = 34, textColor = color, borderColor = color, backgroundColor = black)
  private def partialCondition(
    `class`: Option[ItemClass],
    width: Option[Width] = None,
    height: Option[Height] = None,
    dropLevel: Option[Int] = None
  ) =
    Condition(
      `class` = `class`,
      width = width,
      height = height,
      itemLevel = (minItemLevel, 100),
      rarity = Some(Rarity(Rare)),
      identified = false,
      dropLevel = dropLevel.map(i => DropLevel(1, i))
    )

  private val weapons =
    Block(partialCondition(None, 1, 3), equipmentAction)
  private val smallBows =
    Block(partialCondition(Seq("Bows"), 2, 3), equipmentAction)
  private val armor = Block(partialCondition(settings.armourClasses), equipmentAction)
  private val accessories = Block(
    partialCondition(settings.accessoriesClasses),
    Action(
      size = 37,
      textColor = color.lighten,
      borderColor = color.darken,
      backgroundColor = black
    )
  )

  override def categoryBlocks: FilterLevel => Future[NonEmptyList[Block]] = {
    case Normal =>
      Future.successful(NonEmptyList.of(accessories, weapons.hidden, smallBows.hidden, armor.hidden))
    case Racing =>
      Future.successful(NonEmptyList.of(accessories, weapons, smallBows, armor))
    case _ =>
      Future.successful(NonEmptyList.of(accessories.hidden, weapons.hidden, smallBows.hidden, armor.hidden))
  }
}
