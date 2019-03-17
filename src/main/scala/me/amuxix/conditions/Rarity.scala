package me.amuxix.conditions

import me.amuxix._

/**
  * Created by Amuxix on 03/03/2017.
  */
sealed class GameRarity(val value: Int) extends Named with Ordered[GameRarity] {
  override def compare(that: GameRarity): Int = value compare that.value
}

object GameRarity {
  def fromValue(value: Int): GameRarity = value match {
    case Normal.value => Normal
    case Magic.value  => Magic
    case Rare.value   => Rare
    case Unique.value => Unique
    case _            => throw new InvalidArgument
  }
}
case object Normal extends GameRarity(0)
case object Magic extends GameRarity(1)
case object Rare extends GameRarity(2)
case object Unique extends GameRarity(3)

object Rarity {
  def apply(rarity: GameRarity): Rarity = new Rarity(rarity)
}

case class Rarity(from: GameRarity, to: GameRarity) extends Writable with Mergeable[Rarity] {
  def this(rarity: GameRarity) = this(rarity, rarity)

  val start: Int = from.value
  val end: Int = to.value
  val max: Int = 3
  val conditionName: String = "Rarity"

  private def containsOrIsAdjacent(elem: Int): Boolean = start - 1 <= elem && elem <= end + 1

  override def canMerge(other: Rarity): Boolean =
    (this containsOrIsAdjacent other.start) || (this containsOrIsAdjacent other.end) ||
      (other containsOrIsAdjacent this.start) || (other containsOrIsAdjacent this.end)

  override def merge(other: Rarity): Rarity = Rarity(GameRarity.fromValue(start min other.start), GameRarity.fromValue(end max other.end))

  override def print: String = {
    val startRarity = GameRarity.fromValue(start)
    val endRarity = GameRarity.fromValue(end)
    start match {
      case `end`           => s"$conditionName $startRarity"
      case 0               => s"$conditionName <= $endRarity"
      case _ if end == max => s"$conditionName >= $startRarity"
      case _               => s"$conditionName >= $startRarity\n  $conditionName <= $endRarity"
    }
  }
}
