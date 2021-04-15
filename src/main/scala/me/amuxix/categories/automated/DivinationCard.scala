package me.amuxix.categories.automated
import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions._
import me.amuxix.actions.Color.divinationBlue
import me.amuxix.actions.Sound.{probablyShit, topDivCards}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.Item
import me.amuxix.providers.Provider

object DivinationCard extends AutomatedCategory {
  override protected def items(provider: Provider): NonEmptyList[Item] = provider.divinationCards.all
  override protected def action: Priced => Action =
    AutomatedCategory.automaticActionWithSound(divinationBlue, probablyShit, topDivCards, Blue)
}
