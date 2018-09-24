package me.amuxix.categories2
import me.amuxix.{Epic, FilterRarity, Rare, Uncommon}
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem
import me.amuxix.items.Maps.maps

object Maps extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] = maps.flatMap { map =>
    Seq(
      new GenItem(Epic) { override protected def condition: Condition = map.sameTierOrUpgrade },
      new GenItem(Rare) { override protected def condition: Condition = map.good },
      map,
    )
  }
  override protected def actionForRarity(rarity:  FilterRarity): Action = ???
}
