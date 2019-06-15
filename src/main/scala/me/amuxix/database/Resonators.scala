package me.amuxix.database

import cats.data.NonEmptyList
import me.amuxix.ItemFilter.ec
import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.currency.Resonator

import scala.concurrent.Future

class ResonatorsTable(tag: Tag) extends Table[Resonator](tag, "resonators") with CommonColumns[Resonator] {
  def reforges = column[Boolean]("reforges")
  override def * =
    (
      name,
      reforges,
      dropEnabled,
    ).mapTo[Resonator]
}

object Resonators extends BasicOperations[Resonator, ResonatorsTable](new ResonatorsTable(_)) {
  lazy val chaotic: Future[NonEmptyList[Resonator]] =
    db.run(filter(_.reforges).result).map {
      case Seq(head, tail @ _*) => NonEmptyList(head, tail.toList)
    }

  lazy val alchemical: Future[NonEmptyList[Resonator]] =
    db.run(filter(_.reforges === false).result).map {
      case Seq(head, tail @ _*) => NonEmptyList(head, tail.toList)
    }
}
