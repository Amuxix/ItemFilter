package me.amuxix.conditions

import me.amuxix.{Mergeable, Writable, Writer}

abstract class OperatorWritable[T <: OperatorWritable[T]](val max: Int, val conditionName: String) extends Writable with Mergeable[T] {
  val start: Int
  val end: Int
  val min: Int = 0

  private def containsOrIsAdjacent(elem: Int): Boolean = start - 1 <= elem && end + 1 >= elem

  private def contains(elem: Int): Boolean = start <= elem && end >= elem

  def canCombine(other: T): Boolean = (this containsOrIsAdjacent other.start) || (this containsOrIsAdjacent other.end) || (other containsOrIsAdjacent this.start) || (other containsOrIsAdjacent this.end)

  override def canMerge(other: T): Boolean = //this.start == other.start && this.end == other.end
    (this contains other.start) && (this contains other.end)

  override def print: String = start match {
    case `end`               => s"$conditionName $start"
    case `min` if end == max => ""
    case `min`               => s"$conditionName <= $end"
    case _ if end == max     => s"$conditionName >= $start"
    case _                   => s"$conditionName >= $start\n  $conditionName <= $end"
  }
}

object OperatorWritable {

  implicit def writer[T <: OperatorWritable[T]]: Writer[OperatorWritable[T]] = thing => thing.start match {
    case thing.end => s"${thing.conditionName} ${thing.start}"
    case thing.min if thing.end == thing.max => ""
    case thing.min => s"${thing.conditionName} <= ${thing.end}"
    case _ if thing.end == thing.max => s"${thing.conditionName} >= ${thing.start}"
    case _ => s"${thing.conditionName} >= ${thing.start}\n  ${thing.conditionName} <= ${thing.end}"
  }
}
