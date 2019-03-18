package me.amuxix.database

import cats.data.NonEmptyList
import me.amuxix.ItemFilter.ec
import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.Currency

import scala.concurrent.Future

class CurrenciesTable(tag: Tag) extends Table[Currency](tag, "currency") with CommonColumns[Currency] {
  def stackSize = column[Int]("stack_size")
  def currencyType = column[String]("currency_type")

  override def * = (
    name,
    stackSize,
    currencyType,
    dropEnabled,
  ).mapTo[Currency]
}

object Currencies extends BasicOperations[Currency, CurrenciesTable](new CurrenciesTable(_)) {
  private def getByCurrencyType(currencyType: String): Future[NonEmptyList[Currency]] =
    db.run(filter(_.currencyType === currencyType).result).map {
      case Seq(head, tail @ _*) => NonEmptyList(head, tail.toList)
    }

  lazy val fossils: Future[NonEmptyList[Currency]] =
    getByCurrencyType("Fossil")

  lazy val resonators: Future[NonEmptyList[Currency]] =
    getByCurrencyType("Resonator")

  lazy val orbs: Future[NonEmptyList[Currency]] =
    getByCurrencyType("Orb")

  lazy val vials: Future[NonEmptyList[Currency]] =
    getByCurrencyType("Vial")
}
