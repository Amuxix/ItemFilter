package me.amuxix.items
import me.amuxix.FilterRarity
import me.amuxix.FilterRarity.Undetermined

abstract class Base extends Item with Dimensions with Uniques with PureRarity {
  override val rarity: FilterRarity = Undetermined
  override lazy val `class`: String = className
}
