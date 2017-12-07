package me.amuxix

import me.amuxix.actions.Size

abstract class Writable {
  protected def print: String

  /*final def write(default: Writable): Option[String] = default match {
    case _ if this == default => None
    case _ => Some(this.print)
  }*/

  final def write: Option[String] = this match {
    case _: Size if this.asInstanceOf[Size].size == Size.default => None
    case _ => Some(this.print)
  }
}

object Writable {
  def addQuotesIfMultiWorded(string: String): String = {
    if (string.contains(" ")) {
      s""""$string""""
    } else {
      string
    }
  }
}