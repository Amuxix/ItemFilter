package me.amuxix.categories2
import me.amuxix.{AlwaysHide, FilterRarity, Undetermined}
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{transparent, white}
import me.amuxix.conditions.{Condition, Magic, Rare}
import me.amuxix.items.GenItem

object LastCall extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = Seq(
    new GenItem(AlwaysHide) { override protected def condition: Condition = Condition(
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
    ) },
    new GenItem(AlwaysHide) { override protected def condition: Condition = Condition(
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
      rarity = Rare,
    ) },
    new GenItem(Undetermined) { override protected def condition: Condition = Condition() }
  )
  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case AlwaysHide =>
      Action(size = 18, backgroundColor = transparent, borderColor = transparent, textColor = transparent)
    case Undetermined =>
      Action(textColor = white, backgroundColor = white, borderColor = white)
  }
}
