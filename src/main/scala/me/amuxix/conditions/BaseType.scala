package me.amuxix.conditions

import me.amuxix.{InvalidArgument, Writable}

/**
  * Created by Amuxix on 03/03/2017.
  */
object BaseType {
  implicit def string2BaseType(string: String*): BaseType = BaseType(string: _*)

  def unapply(arg: BaseType): Option[Seq[String]] = Some(arg.bases)
}

case class BaseType(bases: String*) extends Writable {
  if (bases.contains("")) throw new InvalidArgument

  override def print: String = s"BaseType ${bases.mkString("\"", "\" \"", "\"")}"
}
