package me

import cats.Show
import cats.Show.ContravariantShow

package object amuxix {
  implicit def optionShow[T: ContravariantShow]: Show[Option[T]] = _.fold("")(_.show)

  implicit class ContravariantShowOps[-T](t: T)(implicit S: ContravariantShow[T]) {
    def show: String = S.show(t)
  }
}
