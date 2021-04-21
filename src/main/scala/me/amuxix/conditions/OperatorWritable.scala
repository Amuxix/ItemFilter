package me.amuxix.conditions

import cats.Show.ContravariantShow
import me.amuxix.Mergeable

abstract class OperatorWritable[T <: OperatorWritable[T]](val max: Int, val conditionName: String) {
  val start: Int
  val end: Int
  val min: Int = 0
}

object OperatorWritable {

  implicit def show[T <: OperatorWritable[T]]: ContravariantShow[OperatorWritable[T]] = thing =>
    thing.start match {
      case thing.end                           => s"${thing.conditionName} ${thing.start}"
      case thing.min if thing.end == thing.max => ""
      case thing.min                           => s"${thing.conditionName} <= ${thing.end}"
      case _ if thing.end == thing.max         => s"${thing.conditionName} >= ${thing.start}"
      case _                                   => s"${thing.conditionName} >= ${thing.start}\n  ${thing.conditionName} <= ${thing.end}"
    }

  implicit def merge[T <: OperatorWritable[T]](apply: (Int, Int) => T): Mergeable[T] = new Mergeable[T] {
    override def canMerge(one: T, other: T): Boolean =
      (one.start <= other.start && one.end >= other.start) && (one.start <= other.end && one.end >= other.end)

    override def merge(one: T, other: T): T = apply(one.start min other.start, one.end max other.end)
  }
}
