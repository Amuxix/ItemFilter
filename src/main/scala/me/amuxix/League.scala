package me.amuxix

import cats.implicits.catsSyntaxOptionId

sealed abstract class League(val parent: Option[League]) extends Named {
  val name: String = className
}

case class Temporary(override val name: String) extends League(Standard.some)
case class TemporaryHardcore(override val name: String) extends League(Hardcore.some)
case object Hardcore extends League(None)
case object Standard extends League(None)
