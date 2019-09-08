package me.amuxix.items

import cats.data.OptionT
import cats.effect.IO
import me.amuxix.conditions.{Condition, Unique}
import me.amuxix.database.Bases

case class UniqueItem(name: String, baseName: String, dropEnabled: Boolean) extends Item with Area with ProviderPrice {
  override val dropLevel: Int = 1
  override val area: OptionT[IO, Int] = Bases.getByName(baseName).flatMap(_.area)
  override val `class`: String = ""
  override def condition: IO[Condition] =
    IO.pure(
      Condition(
        base = baseName,
        rarity = Unique,
      )
    )
}
