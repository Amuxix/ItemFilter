package me.amuxix.categories2.currency
import me.amuxix.FilterRarity
import me.amuxix.actions.Color.delveOrange
import me.amuxix.actions.{Action, Brown, Circle}
import me.amuxix.categories2.AutomatedCategory
import me.amuxix.items.GenItem
import me.amuxix.items.currency.delve.Fossil.fossils

object Fossil extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = fossils
  override protected def actionForRarity(rarity: FilterRarity): Action = Action(
    size = 40,
    borderColor = delveOrange.lighten,
    backgroundColor = delveOrange.darken,
    textColor = delveOrange.lighten,
    minimapIcon = (Brown, Circle),
  )
}