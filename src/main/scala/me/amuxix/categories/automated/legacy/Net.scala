package me.amuxix.categories.automated.legacy
import me.amuxix.FilterRarity
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.items.GenItem
import me.amuxix.items.currency.Net.nets

object Net extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = nets
  override protected def actionForRarity(rarity: FilterRarity): Action = Action(size = 45, borderColor = Color.nets.darken, textColor = Color.nets.darken.darken, backgroundColor = Color.goodYellow.lighten)
}
