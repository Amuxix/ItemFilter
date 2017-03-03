package me.amuxix.conditions

/**
  * Created by Amuxix on 03/03/2017.
  */
object BaseType {
  def apply(base: String): BaseType = new BaseType(base)
}
case class BaseType(bases: Seq[String]) extends BaseCondition {
  def this(base: String) = this(Seq(base))
  override def toString: String = super.toString + s" ${bases.map(s => s"\"$s\"")}"
}
