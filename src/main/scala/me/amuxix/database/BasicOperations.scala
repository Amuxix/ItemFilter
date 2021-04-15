package me.amuxix.database

import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix.ItemFilter
import me.amuxix.database.PostgresProfile.API._
import slick.lifted.Tag

abstract class BasicOperations[Element, T <: Table[Element] with CommonColumns[Element]](cons: Tag => T) extends TableQuery(cons) {
  lazy val all: IO[NonEmptyList[Element]] = IO.fromFuture(IO(ItemFilter.db.run(this.result))).map(seq => NonEmptyList.fromListUnsafe(seq.toList))
}
