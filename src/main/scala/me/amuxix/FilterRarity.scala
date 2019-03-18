package me.amuxix

sealed abstract class FilterRarity(private val multiplier: Double) extends Ordered[FilterRarity] {
  lazy val threshold: Double = multiplier * ItemFilter.config.threshold
  override def compare(that: FilterRarity): Int = multiplier compare that.multiplier
}

sealed trait Priced

case object AlwaysShow extends FilterRarity(Int.MaxValue)
case object AlwaysHide extends FilterRarity(Int.MinValue)

case object Undetermined extends FilterRarity(Int.MaxValue)

case object Leveling extends FilterRarity(0) with Priced
case object Common extends FilterRarity(1) with Priced // .04C
case object Uncommon extends FilterRarity(12.5) with Priced // .5C
case object Rare extends FilterRarity(25) with Priced // 1C
case object Epic extends FilterRarity(200) with Priced // 8C
case object Mythic extends FilterRarity(1000) with Priced // 40C
