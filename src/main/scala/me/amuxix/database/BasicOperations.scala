package me.amuxix.database

import me.amuxix.ItemFilter
import me.amuxix.database.PostgresProfile.api._
import slick.lifted.Tag

import scala.concurrent.Future

abstract class BasicOperations[Element, T <: Table[Element] with NamedTable[Element]](cons: Tag => T) extends TableQuery(cons) {
  val db: Database = ItemFilter.db
  implicit val ec = ItemFilter.ec

  def getByName(name: String): Future[Element] =
    db.run(filter(_.name === name).result.headOption).map(_.get)

  def all: Future[Seq[Element]] =
    db.run(this.result)
}
