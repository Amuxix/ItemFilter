package me.amuxix.conditions

import me.amuxix.{Default, Named, Operator, ValueEquals}

/**
  * Created by Amuxix on 03/03/2017.
  */
sealed class R extends Named
object Normal extends R
object Magic extends R
object Rare extends R
object Unique extends R

object Rarity extends Default[Rarity] {
  def apply(quality: R): Rarity = new Rarity(quality)

  /** *
    * This specifies a default value of the T type, it doesn't really matter what it's value is as
    * will only compared by reference
    */
  override val default = Rarity(">=", Normal)
}

case class Rarity(op: Operator, r: R) extends BaseCondition with ValueEquals {
  def this(r: R) = this("=", r)
  override def print: String = s"Rarity ${op.print}${r.name}"
}
