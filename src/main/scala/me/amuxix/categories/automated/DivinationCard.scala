package me.amuxix.categories.automated
import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.actions.Action
import me.amuxix.actions.Color.divinationBlue
import me.amuxix.actions.Sound.{probablyShit, topDivCards}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.database.DivinationCards
import me.amuxix.items.Item
import me.amuxix.FilterRarity.Priced
import me.amuxix.actions.EffectColor.Blue

object DivinationCard extends AutomatedCategory {
  override protected lazy val items: IO[NonEmptyList[Item]] =
    DivinationCards.all
  override protected def action: Priced => Action =
    AutomatedCategory.automaticActionWithSound(divinationBlue, probablyShit, topDivCards, Blue)
}
