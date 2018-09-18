package me.amuxix

sealed abstract case class FilterRarity(private val multiplier: Int) extends Ordered[FilterRarity] {
  lazy val threshold: Double = ItemFilter.threshold * multiplier
  override def compare(that: FilterRarity): Int = multiplier compare that.multiplier
}

object Undetermined extends FilterRarity(0)
object Common extends FilterRarity(1)
object Uncommon extends FilterRarity(2)
object Rare extends FilterRarity(5)
object Epic extends FilterRarity(20)
object Mythic extends FilterRarity(100)
