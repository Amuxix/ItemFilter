package me.amuxix

sealed abstract class FilterRarity(private val multiplier: Int) extends Ordered[FilterRarity] {
  lazy val threshold: Double = multiplier * ItemFilter.threshold
  override def compare(that: FilterRarity): Int = multiplier compare that.multiplier
}

case object Undetermined extends FilterRarity(Int.MaxValue)
case object Leveling extends FilterRarity(0)

case object AlwaysShow extends FilterRarity(Int.MaxValue)
case object AlwaysHide extends FilterRarity(Int.MinValue)

case object Common extends FilterRarity(1)    // .04C
case object Uncommon extends FilterRarity(13) // .52C
case object Rare extends FilterRarity(25)     // 1C
case object Epic extends FilterRarity(200)    // 8C
case object Mythic extends FilterRarity(1000) // 40C
