package me.amuxix.items
import me.amuxix.{FilterRarity, Undetermined}

abstract class CategoryItem(filterRarity: FilterRarity = Undetermined) extends GenItem("") {
  override lazy val chaosValuePerSlot: Option[Double] = None //This is never be used because we override rarity

  override lazy val rarity: FilterRarity = filterRarity
}
