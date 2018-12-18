package me.amuxix.conditions
import me.amuxix.{Mergeable, Writable}

abstract class OperatorWritable[T <: OperatorWritable[T]](max: Int, conditionName: String) extends Writable with Mergeable[T] {
  val start: Int
  val end: Int
  val min: Int = 0

  private def containsOrIsAdjacent(elem: Int): Boolean = start - 1 <= elem && elem <= end + 1

  override def canMerge(other: T): Boolean = {
    (this containsOrIsAdjacent other.start) || (this containsOrIsAdjacent other.end) ||
      (other containsOrIsAdjacent this.start) || (other containsOrIsAdjacent this.end)
  }

  override def print: String = start match {
    case `end`               => s"$conditionName $start"
    case `min` if end == max => ""
    case `min`               => s"$conditionName <= $end"
    case _ if end == max     => s"$conditionName >= $start"
    case _                   => s"$conditionName >= $start\n  $conditionName <= $end"
  }
}