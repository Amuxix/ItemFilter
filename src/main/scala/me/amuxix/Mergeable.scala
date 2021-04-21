package me.amuxix

import cats.data.NonEmptyList
import cats.effect.IO
import cats.syntax.parallel._
import me.amuxix.syntax.mergeable._

import scala.annotation.tailrec

object Mergeable {
  @tailrec def merge[T: Mergeable](items: NonEmptyList[T], merged: List[T] = List.empty): NonEmptyList[T] =
    items match {
      case NonEmptyList(first, rest) =>
        val (mergedItem, unmergeable) = rest.foldLeft((first, List.empty[T])) {
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

  def parMerge[T: Mergeable](items: NonEmptyList[T]): IO[NonEmptyList[T]] = {
    @tailrec def groupByMergeables(remainingItems: NonEmptyList[T], groups: List[NonEmptyList[T]] = List.empty): List[NonEmptyList[T]] = remainingItems match {
      case NonEmptyList(first, rest) =>
        rest.partition(first.canMerge) match {
          case (mergeables, List()) => groups :+ NonEmptyList.of(first, mergeables: _*)
          case (mergeables, List(unmergeable)) => groups :+ NonEmptyList.of(first, mergeables: _*) :+ NonEmptyList.one(unmergeable)
          case (mergeables, unmergeables) => groupByMergeables(NonEmptyList.fromListUnsafe(unmergeables), groups :+ NonEmptyList.of(first, mergeables: _*))
        }
    }
    def merge(items: NonEmptyList[T]): IO[T] = IO(items.tail.fold(items.head)(_ merge _))

    groupByMergeables(items).parTraverse(merge).map(NonEmptyList.fromListUnsafe)
  }

  def equal[T, A](f: T => A): Mergeable[T] = new Mergeable[T] {
    override def canMerge(one: T, other: T): Boolean = f(one) == f(other)

    override def merge(one: T, other: T): T = one
  }


  def join[T, A](apply: Seq[A] => T, f: T => Seq[A]): Mergeable[T] = new Mergeable[T] {
    override def canMerge(one: T, other: T): Boolean = true

    override def merge(one: T, other: T): T = apply((f(one) ++ f(other)).distinct)
  }
}

trait Mergeable[T] {
  def canMerge(one: T, other: T): Boolean

  def merge(one: T, other: T): T
}
