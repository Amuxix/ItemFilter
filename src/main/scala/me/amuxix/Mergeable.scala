package me.amuxix

object Mergeable {
  def merge[T <: Mergeable[T]](seq: Seq[T]): Seq[T] = {
    if (seq.isEmpty) {
      Seq.empty
    } else {
      val h = seq.head
      seq.view.filter(h.canMerge).reduceLeft((a, b) => a.merge(b)) +: merge(seq.filterNot(h.canMerge))
    }
  }
}

trait Mergeable[T] {
  def canMerge(other: T): Boolean

  def merge(other: T): T
}