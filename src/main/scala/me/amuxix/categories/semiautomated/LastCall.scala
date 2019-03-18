package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix.{AlwaysHide, AlwaysShow, FilterRarity}
import me.amuxix.ItemFilter._
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{black, white}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, Normal, Rare}
import me.amuxix.items.{CategoryItem, GenItem}

import scala.concurrent.Future

object LastCall extends SemiAutomatedCategory {
  override protected val categoryItems: Future[NonEmptyList[GenItem]] = Future.successful(
    NonEmptyList.fromListUnsafe(List(
      new CategoryItem(AlwaysHide) {
        override lazy val condition: Future[Condition] = Future.successful(Condition(
          `class` = config.accessoriesClasses ++ config.armourClasses ++ config.weaponClasses ++ config.shieldClasses ++ config.flaskClasses,
          rarity = (Normal, Rare),
        ))
      },
      new CategoryItem(AlwaysShow) { override lazy val condition: Future[Condition] = Future.successful(Condition()) }
    ))
  )
  override protected def actionForRarity: FilterRarity => Action = {
    case AlwaysHide =>
      Action(size = 18, backgroundColor = black.halfTransparent, borderColor = black, textColor = white.halfTransparent)
    case _ =>
      Action(textColor = white.darken, backgroundColor = white, borderColor = white)
  }
}
