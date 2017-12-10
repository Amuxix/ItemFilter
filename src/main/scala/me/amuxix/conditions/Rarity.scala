package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
sealed class R(val name: String)
object White extends R("Normal")
object Magic extends R("Magic")
object Rare extends R("Rare")
object Unique extends R("Unique")

object Rarity {
  implicit def tuple22Rarity(tuple: (Operator, R)): Rarity = Rarity(tuple._1, tuple._2)
  def apply(quality: R): Rarity = new Rarity(quality)
}

case class Rarity(op: Operator, rarity: R) extends Writable {
  def this(r: R) = this("=", r)
  override def print: String = s"Rarity ${op.print}${rarity.name}"
}
