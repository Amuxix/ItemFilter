package me.amuxix

import cats.data.NonEmptyList

import scala.annotation.tailrec
import scala.language.higherKinds

object Mergeable {
  @tailrec def merge[T <: Mergeable[T]](unmerged: NonEmptyList[T], merged: List[T] = List.empty): NonEmptyList[T] =
    unmerged.toList match {
      case h :: t =>
        val (mergeable, unmergeable) = t.partition(h.canMerge)
        val nonEmptyMerged = NonEmptyList.fromListUnsafe(merged :+ mergeable.foldLeft(h)(_ merge _))
        unmergeable match {
          case h :: t => merge(NonEmptyList(h, t), nonEmptyMerged.toList)
          case _      => nonEmptyMerged
        }
      case _ => NonEmptyList.fromListUnsafe(merged)
    }
}

trait Mergeable[T] {
  def canMerge(other: T): Boolean

  def merge(other: T): T
}
