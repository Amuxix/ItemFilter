package me.amuxix.items

import cats.effect.IO
import me.amuxix._
import me.amuxix.conditions.Condition

abstract class Item extends GenericItem with Named with ImplicitConversions {
  val name: String
  val dropLevel: Int
  val dropEnabled: Boolean

  val `class`: String

  override def condition: IO[Condition] =
    IO.pure(
      Condition(
        `class` = `class`,
        base = name,
      )
    )
}
