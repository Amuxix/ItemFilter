package me.amuxix.categories.automated

import me.amuxix._
import me.amuxix.actions.Color.{black, divinationBlue}
import me.amuxix.actions.Sound.{divCards, topDivCards}
import me.amuxix.actions._
import me.amuxix.items.GenItem

object DivinationCard extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = items.DivinationCard.all
  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case AlwaysHide | Common =>
      Action(
        backgroundColor = black,
        textColor = divinationBlue,
      )
    case Uncommon =>
      Action(
        size = 36,
        sound = divCards,
        backgroundColor = black,
        textColor = divinationBlue.darken,
        borderColor = divinationBlue.darken,
        beam = (Blue, true),
      )
    case Rare =>
      Action(
        size = 36,
        sound = divCards,
        backgroundColor = black,
        textColor = divinationBlue,
        borderColor = divinationBlue,
        minimapIcon = (Blue, Diamond),
        beam = (Blue, true),
      )
    case Epic =>
      Action(
        size = 40,
        sound = divCards,
        backgroundColor = divinationBlue.darken,
        textColor = black,
        borderColor = black,
        minimapIcon = (Blue, Hexagon),
        beam = Blue,
      )
    case _ =>
      Action(
        size = 45,
        sound = topDivCards,
        backgroundColor = divinationBlue,
        textColor = black,
        borderColor = black,
        minimapIcon = (Blue, Star),
        beam = Blue,
      )
  }
}
