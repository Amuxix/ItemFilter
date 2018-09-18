package me.amuxix.categories2
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.conditions.{Condition, Magic}
import me.amuxix.items.GenItem

object LastCall extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = Seq(
    new GenItem() { override protected def condition: Condition = Condition(
      `class` = Seq(
        "Flasks",
        "Gloves",
        "Boots",
        "Body Armours",
        "Helmets",
        "Rings",
        "Belts",
        "Amulets",
        "Claws",
        "Daggers",
        "Wands",
        "Swords",
        "Bows",
        "Staves",
        "Axes",
        "Maces",
        "Quivers",
        "Shields",
        "Sceptres"
      ),
      rarity = ("<=", Magic),
    ) }
  )
  override protected def actionForRarity(rarity: FilterRarity): Action = ???
}
