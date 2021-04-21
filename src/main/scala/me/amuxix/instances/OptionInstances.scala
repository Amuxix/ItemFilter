package me.amuxix.instances

import cats.Show
import cats.Show.ContravariantShow
import me.amuxix.syntax.contravariantShow._
import me.amuxix.syntax.mergeable._
import me.amuxix.Mergeable

trait OptionInstances {
  @inline implicit final def optionShow[T: ContravariantShow]: Show[Option[T]] = _.fold("")(_.show)

  @inline implicit final def optionMergeable[T: Mergeable]: Mergeable[Option[T]] = new Mergeable[Option[T]] {
    override def canMerge(one: Option[T], other: Option[T]): Boolean = (one, other) match {
      case (Some(m1), Some(m2)) => m1 canMerge m2
      case (None, None)         => true
      case _                    => false
    }

    override def merge(one: Option[T], other: Option[T]): Option[T] = (one, other) match {
      case (Some(m1), Some(m2)) => Some(m1 merge m2)
      case (None, None)         => None
      case _                    => throw new Exception("Attempting to merge un-mergeable things.")
    }
  }
}
