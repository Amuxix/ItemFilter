package me.amuxix

import scala.annotation.tailrec

object Mergeable {
  @tailrec def merge[T <: Mergeable[T]](unmerged: Seq[T], merged: Seq[T] = Seq.empty): Seq[T] =
    unmerged match {
      case h :: t =>
        val (mergeable, unmergeable) = t.partition(h.canMerge)
        merge(unmergeable, merged :+ mergeable.foldLeft(h)(_ merge _))
      case _ => merged
    }
}

trait Mergeable[T] {
  def canMerge(other: T): Boolean

  def merge(other: T): T
}
