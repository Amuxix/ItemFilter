package me.amuxix

import me.amuxix.actions.Size

abstract class Writable {
  protected def print: String

  final def write: Option[String] = this match {
    case _: Size if this.asInstanceOf[Size].size == Size.default => None
    case _                                                       => Some(this.print)
  }
}
