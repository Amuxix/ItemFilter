package me.amuxix.database

import me.amuxix.ItemFilter
import me.amuxix.database.PostgresProfile.api._

import scala.concurrent.{ExecutionContext, Future}

trait BasicOperations[Element] {
  val db: Database = ItemFilter.db
  implicit val ec = ExecutionContext.global

  type Table <: NamedTable[Element]

  val query = TableQuery[Table]

  def getByName(name: String): Future[Element] =
    db.run(query.filter(_.name === name).result.headOption).map(_.get)

  def all: Future[Seq[Element]] =
    db.run(query.result)
}
