package me.amuxix.database

import cats.data.{NonEmptyList, OptionT}
import me.amuxix.ItemFilter
import me.amuxix.ItemFilter.ec
import me.amuxix.database.PostgresProfile.API._
import slick.lifted.Tag

import scala.concurrent.Future

abstract class BasicOperations[Element, T <: Table[Element] with CommonColumns[Element]](cons: Tag => T) extends TableQuery(cons) {
  val db: Database = ItemFilter.db

  def getByName(name: String): OptionT[Future, Element] =
    OptionT(db.run(filter(_.name === name).result.headOption))

  lazy val all: Future[NonEmptyList[Element]] =
    db.run(this.result).map {
      case Seq(head, tail @ _*) => NonEmptyList(head, tail.toList)
    }
}
