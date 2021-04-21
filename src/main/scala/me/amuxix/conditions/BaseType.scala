package me.amuxix.conditions

import cats.Show
import me.amuxix.{InvalidArgument, Mergeable}

/**
  * Created by Amuxix on 03/03/2017.
  */
object BaseType {
  implicit val show: Show[BaseType] = baseType => s"BaseType ${baseType.bases.mkString("\"", "\" \"", "\"")}"

  implicit val mergeable: Mergeable[BaseType] = Mergeable.join(apply, _.bases)
}

case class BaseType(bases: String*) {
  if (bases.contains("")) throw new InvalidArgument
}
