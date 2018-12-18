package me.amuxix.categories.automated

import me.amuxix.ItemFilter._
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{transparent, white}
import me.amuxix.conditions.{Condition, Normal, Rare}
import me.amuxix.items.{CategoryItem, GenItem}
import me.amuxix.{AlwaysHide, AlwaysShow, FilterRarity}

object LastCall extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = Seq(
    new CategoryItem(AlwaysHide) { override def condition: Condition = Condition(
      `class` = accessoriesClasses ++ armourClasses ++ weaponClasses ++ shieldClasses ++ flaskClasses,
      rarity = (Normal, Rare),
    ) },
    new CategoryItem(AlwaysShow) { override def condition: Condition = Condition() }
  )
  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case AlwaysHide =>
      Action(size = 18, backgroundColor = transparent, borderColor = transparent, textColor = transparent)
    case _ =>
      Action(textColor = white, backgroundColor = white, borderColor = white)
  }
}
