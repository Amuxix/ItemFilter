package me.amuxix.database

import cats.data.{NonEmptyList, OptionT}
import cats.effect.IO
import me.amuxix.ItemFilter.{contextShift, db, ec}
import me.amuxix.database.PostgresProfile.API._
import slick.lifted.Tag

abstract class BasicOperations[Element, T <: Table[Element] with CommonColumns[Element]](cons: Tag => T) extends TableQuery(cons) {
  def getByName(name: String): OptionT[IO, Element] =
    OptionT(IO.fromFuture(IO {
      //println("Hitting DB")
      db.run(filter(_.name === name).result.headOption)
    }))

  lazy val all: IO[NonEmptyList[Element]] = IO.fromFuture(IO {
    //println("Hitting DB")
    db.run(this.result).map {
      case Seq(head, tail @ _*) => NonEmptyList(head, tail.toList)
    }
  })
}
