package me.amuxix

import me.amuxix.actions.Size

abstract class Writable {
  protected def print: String

  final def write: Option[String] = this match {
    case size: Size if size.size == Size.default.size => None
    case _ if print.isEmpty                           => None
    case _                                            => Some(this.print)
  }
}
