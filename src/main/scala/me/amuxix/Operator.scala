package me.amuxix

sealed abstract class Operator(protected[Operator] val text: String = "") {
  val print: String = this match {
    case Greater | GreaterOrEqual | Lesser | LesserOrEqual => this.text + " "
    case _ => ""
  }
}

object Operator {
  implicit def string2Operator(op: String): Operator = op match {
    case Equals.text => Equals
    case Greater.text => Greater
    case GreaterOrEqual.text => GreaterOrEqual
    case Lesser.text => Lesser
    case LesserOrEqual.text => LesserOrEqual
    case _ => Nothing
  }
}

object Equals extends Operator("=")
object Greater extends Operator(">")
object GreaterOrEqual extends Operator(">=")
object Lesser extends Operator("<=")
object LesserOrEqual extends Operator("<=")
object Nothing extends Operator