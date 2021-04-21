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
  def apply(rarity: GameRarity): Rarity = new Rarity(rarity, rarity)

  implicit val show: Show[Rarity] = rarity => {
    rarity.from match {
      case rarity.to                => show"Rarity ${rarity.from}"
      case Normal                   => show"Rarity <= ${rarity.to}"
      case _ if rarity.to == Unique => show"Rarity >= ${rarity.from}"
      case _                        => show"Rarity >= ${rarity.from}\n  Rarity <= ${rarity.to}"
    }
  }

  implicit val mergeable: Mergeable[Rarity] = new Mergeable[Rarity] {
    override def canMerge(one: Rarity, other: Rarity): Boolean = (one containsOrIsAdjacent other.from) || (one containsOrIsAdjacent other.to) || (other containsOrIsAdjacent one.from) || (other containsOrIsAdjacent one.to)

    override def merge(one: Rarity, other: Rarity): Rarity = Rarity(one.from min other.from, one.to max other.to)
  }
}

case class Rarity(from: GameRarity, to: GameRarity) {
  private def containsOrIsAdjacent(gameRarity: GameRarity): Boolean = from.value - 1 <= gameRarity.value && gameRarity.value <= to.value + 1
}
