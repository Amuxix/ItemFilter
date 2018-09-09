package me.amuxix

sealed case class FilterRarity(multiplier: Int) {

  /**
    * Checks if the given values is of this rarity
    */
  def is(value: Int, filterThreshold: Double): Boolean = value <= multiplier * filterThreshold
}

object Undetermined extends FilterRarity(0)
object Common extends FilterRarity(1)
object Uncommon extends FilterRarity(2)
object Rare extends FilterRarity(5)
object Epic extends FilterRarity(20)
object Mythic extends FilterRarity(100)
