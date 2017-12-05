package me.amuxix

abstract class Writable {
  protected def print: String
  def equals(o: Writable): Boolean

  final def write(default: Writable): Option[String] = default match {
    case _ if this equals default => None
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