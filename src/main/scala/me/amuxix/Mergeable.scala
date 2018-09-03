package me.amuxix

object Mergeable {
  def merge[T <: Mergeable[T]](seq: Seq[T]): Seq[T] = seq match {
    case h :: _ :: _ =>
      val (mergeable, unmergeable) = seq.partition(h.canMerge)
      mergeable.reduceLeft(_ merge _) +: merge(unmergeable)
    case _ => seq
  }

  /*@tailrec def merge[T <: Mergeable[T]](seq: Seq[T], merged: Option[T] = None): Seq[T] =
    seq match {
      case h :: _ :: _ =>
        val (mergeable, unmergeable) = seq.partition(h.canMerge)
        merge(unmergeable, Some(mergeable.reduceLeft(_ merge _)))
      case _ => merged.fold(seq)(_ +: seq)
    }*/
}

trait Mergeable[T] {
  def canMerge(other: T): Boolean

  def merge(other: T): T
}


