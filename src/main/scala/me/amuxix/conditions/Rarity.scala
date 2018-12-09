package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
sealed class GameRarity extends Named
case object White extends GameRarity {
  override lazy val name: String = "Normal"
}
case object Magic extends GameRarity
case object Rare extends GameRarity
case object Unique extends GameRarity

object Rarity {
  implicit def tuple22Rarity(tuple: (Operator, GameRarity)): Rarity = Rarity(tuple._1, tuple._2)
  def apply(quality: GameRarity): Rarity = new Rarity(quality)
}

case class Rarity(op: Operator, rarity: GameRarity) extends Writable {
  def this(r: GameRarity) = this("=", r)
  override def print: String = s"Rarity ${op.print}${rarity.name}"
}
