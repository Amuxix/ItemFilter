package me.amuxix.conditions

import me.amuxix.Named

/**
  * Created by Amuxix on 03/03/2017.
  */
sealed trait R extends Named
object Normal extends R
object Magic extends R
object Rare extends R
object Unique extends R
object Rarity {
  def apply(quality: R): Rarity = new Rarity(quality)
}
case class Rarity(op: String, r: R) extends HasOperator {
  def this(r: R) = this("", r)
  override def toString: String = super.toString + r.name
}
