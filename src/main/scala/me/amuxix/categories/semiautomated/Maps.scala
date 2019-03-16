package me.amuxix.categories.semiautomated

import me.amuxix.ItemFilter.ec
import me.amuxix._
import me.amuxix.actions.Color._
import me.amuxix.actions.Sound._
import me.amuxix.actions._
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.{CategoryItem, GenItem}

import scala.concurrent.Future

object Maps extends SemiAutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = database.Maps.all.map(_.flatMap { map =>
    Seq(
      new CategoryItem(Epic) { override def condition: Condition = map.sameTierOrUpgrade },
      new CategoryItem(Rare) { override def condition: Condition = map.good },
      map,
    )
  })

  override protected def actionForRarity: FilterRarity => Action = {
    case Mythic =>
      Action(
        size = 45,
        sound = betterMaps,
        borderColor = red,
        minimapIcon = (Red, Square),
        beam = Red,
      )
    case Epic =>
      Action(
        size = 40,
        sound = maps,
        borderColor = goodYellow,
        minimapIcon = (Yellow, Square),
        beam = Yellow,
      )
    case Rare =>
      Action(
        borderColor = white,
        sound = maps,
        minimapIcon = (White, Square),
        beam = White,
      )
    case _ => Action(
      sound = maps,
      minimapIcon = (White, Square),
    )
  }
}
