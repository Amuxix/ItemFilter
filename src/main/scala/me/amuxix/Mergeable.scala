package me.amuxix

import cats.data.NonEmptyList

import scala.annotation.tailrec
import scala.collection.parallel.CollectionConverters._

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
  @tailrec def merge[T <: Mergeable[T]](items: NonEmptyList[T], merged: List[T] = List.empty): NonEmptyList[T] =
    items match {
      case NonEmptyList(first, rest) =>
        val (mergedItem, unmergeable) = rest.par.foldLeft((first, List.empty[T])) {
          case ((mergedItem, unmergeable), item) if mergedItem canMerge item =>
            (mergedItem merge item, unmergeable)
          case ((mergedItem, unmergeable), item) =>
            (mergedItem, unmergeable :+ item)
        }
        println(s"Missing ${unmergeable.size}")
        val newlyMerged = merged :+ mergedItem
        unmergeable match {
          case h :: t => merge(NonEmptyList(h, t), newlyMerged)
          case _      => NonEmptyList.fromListUnsafe(newlyMerged)
        }
    }

  def parMerge[T <: Mergeable[T]](items: NonEmptyList[T]): NonEmptyList[T] = {
    @tailrec def groupByMergeables(remainingItems: NonEmptyList[T], groups: List[NonEmptyList[T]] = List.empty): List[NonEmptyList[T]] = remainingItems match {
      case NonEmptyList(first, rest) =>
        rest.partition(first.canMerge) match {
          case (mergeables, List()) => groups :+ NonEmptyList.of(first, mergeables: _*)
          case (mergeables, List(unmergeable)) => groups :+ NonEmptyList.of(first, mergeables: _*) :+ NonEmptyList.one(unmergeable)
          case (mergeables, unmergeables) => groupByMergeables(NonEmptyList.fromListUnsafe(unmergeables), groups :+ NonEmptyList.of(first, mergeables: _*))
        }
    }
    def merge(items: NonEmptyList[T]): T = items.tail.fold(items.head)(_ merge _)

    NonEmptyList.fromListUnsafe(groupByMergeables(items).par.map(merge).seq.toList)
  }
}

trait Mergeable[T] {
  def canMerge(other: T): Boolean

  def merge(other: T): T
}
