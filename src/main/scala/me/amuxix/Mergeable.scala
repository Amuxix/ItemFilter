package me.amuxix

object Mergeable {
  def merge[T <: Mergeable[T]](seq: Seq[T]): Seq[T] =
    if (seq.isEmpty) {
      Seq.empty
    } else {
      val h = seq.head
      val (mergeable, unmergeable) = seq.partition(h.canMerge)
      mergeable.reduceLeft(_ merge _) +: merge(unmergeable)
    }
}

trait Mergeable[T] {
  def canMerge(other: T): Boolean

  def merge(other: T): T
}
