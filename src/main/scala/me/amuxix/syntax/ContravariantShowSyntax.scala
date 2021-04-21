package me.amuxix.syntax

import cats.Show.ContravariantShow

trait ContravariantShowSyntax {
  @inline implicit final def toContravariantShow[T: ContravariantShow](t: T): ContravariantShowOps[T] = new ContravariantShowOps(t)
}

class ContravariantShowOps[T](t: T)(implicit M: ContravariantShow[T]) {
  def show: String = M.show(t)
}