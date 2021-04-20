package me.amuxix.conditions

import cats.Show
import me.amuxix.{InvalidArgument, Mergeable}

/**
  * Created by Amuxix on 03/03/2017.
  */
object BaseType {
  implicit val show: Show[BaseType] = baseType => s"BaseType ${baseType.bases.mkString("\"", "\" \"", "\"")}"
}

case class BaseType(bases: String*) extends Mergeable[BaseType] {
  if (bases.contains("")) throw new InvalidArgument

  override def canMerge(other: BaseType): Boolean = true

  override def merge(other: BaseType): BaseType =
    //noinspection ScalaUnnecessaryParentheses
    BaseType((bases ++ other.bases).distinct: _*)
}
