package me.amuxix

import cats.data.NonEmptyList

import scala.annotation.tailrec
import scala.language.higherKinds

object Mergeable {
  /*private def mergeOption[T <: Mergeable[T]](a: T, b: T): (T, Option[T]) =
    if (a canMerge b) {
      (a merge b, None)
    } else {
      (a, Some(b))
    }

  def merge[F[_] : Reducible, G[_]: Foldable: Alternative, T <: Mergeable[T]](items: F[T])(implicit reducible: NonEmptyReducible[F, G], monoid: Monoid[G[T]]): F[T] = {
    @tailrec def innerMerge(items: F[T], merged: G[T]): F[T] = {
      items.foldLeft((monoid.empty, monoid.empty)) {
        case ((mergeable, unmergeable), item) => mergeable
      }
      reducible.split(items) match {
        case (head, tail) =>
          val (mergeable, unmergeable) = tail.partitionEither(element => Either.cond(head.canMerge(element), element, element))
          val m: G[T] = merged combine Applicative[G].pure(mergeable.foldLeft(head)(_ merge _))
          if (unmergeable.isEmpty) {
            m.asInstanceOf[F[T]]
          } else {
            innerMerge(unmergeable.asInstanceOf[F[T]], m)
          }
      }
    }
    innerMerge(items, monoid.empty)
  }*/
  @tailrec def merge[T <: Mergeable[T]](unmerged: NonEmptyList[T], merged: List[T] = List.empty): NonEmptyList[T] =
    unmerged.toList match {
      case h :: t =>
        val (mergeable, unmergeable) = t.partition(h.canMerge)
        val nonEmptyMerged = NonEmptyList.fromListUnsafe(merged :+ mergeable.foldLeft(h)(_ merge _))
        unmergeable match {
          case h :: t => merge(NonEmptyList(h, t), nonEmptyMerged.toList)
          case _ =>      nonEmptyMerged
        }
      case _ => NonEmptyList.fromListUnsafe(merged)
    }
}

trait Mergeable[T] {
  def canMerge(other: T): Boolean

  def merge(other: T): T
}
