package me.amuxix.categories.automated.recipes
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem
import me.amuxix.items.currency.GlassblowersBauble

object Bauble extends AutomatedCategory {
  def generateGenericItem(quality: Int): GenItem =
    new GenItem {
      override lazy val chaosValuePerSlot: Option[Double] = GlassblowersBauble.chaosValuePerSlot.map(value => (value / 2) / (40 / quality))
      override protected lazy val condition: Condition = Condition(`class` = "Flask", quality = quality)
    }

  override protected val categoryItems: Seq[GenItem] = (1 to 19).map(generateGenericItem) :+
    new GenItem {
      override lazy val chaosValuePerSlot: Option[Double] = GlassblowersBauble.chaosValuePerSlot.map(_ / 2)
      override protected lazy val condition: Condition = Condition(`class` = "Flask", quality = 20)
    }
  override protected def actionForRarity(rarity: FilterRarity): Action = Action()
}
