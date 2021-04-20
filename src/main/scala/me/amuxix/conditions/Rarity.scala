package me.amuxix.conditions

import cats.Show
import me.amuxix._
import cats.syntax.show._

import scala.math.Ordering.Implicits._

/** Created by Amuxix on 03/03/2017.
  */
sealed class GameRarity(val value: Int) extends Named

object GameRarity {
  implicit val ordering: Ordering[GameRarity] = (x, y) => implicitly[Ordering[Int]].compare(x.value, y.value)
  implicit val show: Show[GameRarity] = _.className
}
case object Normal extends GameRarity(0)
case object Magic extends GameRarity(1)
case object Rare extends GameRarity(2)
case object Unique extends GameRarity(3)

object Rarity {
  def apply(rarity: GameRarity): Rarity = new Rarity(rarity)

  implicit val show: Show[Rarity] = rarity => {
    rarity.from match {
      case rarity.to                => show"Rarity ${rarity.from}"
      case Normal                   => show"Rarity <= ${rarity.to}"
      case _ if rarity.to == Unique => show"Rarity >= ${rarity.from}"
      case _                        => show"Rarity >= ${rarity.from}\n  Rarity <= ${rarity.to}"
    }
  }
}

case class Rarity(from: GameRarity, to: GameRarity) extends Mergeable[Rarity] {
  def this(rarity: GameRarity) = this(rarity, rarity)

  private def containsOrIsAdjacent(gameRarity: GameRarity): Boolean = from.value - 1 <= gameRarity.value && gameRarity.value <= to.value + 1

  override def canMerge(other: Rarity): Boolean = (this containsOrIsAdjacent other.from) || (this containsOrIsAdjacent other.to) || (other containsOrIsAdjacent this.from) || (other containsOrIsAdjacent this.to)

  override def merge(other: Rarity): Rarity = Rarity(from min other.from, to max other.to)
}
