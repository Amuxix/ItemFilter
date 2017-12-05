package me.amuxix.conditions

import me.amuxix.Writable.addQuotesIfMultiWorded
import me.amuxix.{Default, InvalidArgument, RefEquals}

/**
  * Created by Amuxix on 03/03/2017.
  */
object BaseType extends Default[BaseType] {
  def apply(base: String): BaseType = new BaseType(base)

  override val default = BaseType("")
}

case class BaseType(bases: Seq[String]) extends BaseCondition with RefEquals {
  def this(base: String) = this(Seq(base))
  if (bases.contains("")) throw new InvalidArgument

  override def print: String = s"BaseType ${bases.map(addQuotesIfMultiWorded).mkString(" ")}"
}
