package me.amuxix.database

import cats.data.NonEmptyList
import me.amuxix.ItemFilter.ec
import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.Currency

import scala.concurrent.Future

class CurrenciesTable(tag: Tag) extends Table[Currency](tag, "currency") with NamedTable[Currency] {
  def stackSize = column[Int]("stack_size")
  def currencyType = column[String]("currency_type")

  override def * = (
    name,
    stackSize,
    currencyType,
  ) <> ((Currency.apply _).tupled, Currency.unapply)
}

object Currencies extends BasicOperations[Currency, CurrenciesTable](new CurrenciesTable(_)) {
  private def getByCurrencyType(currencyType: String): Future[NonEmptyList[Currency]] =
    db.run(filter(_.currencyType === currencyType).result).map {
      case Seq(head, tail @ _*) => NonEmptyList(head, tail.toList)
    }

  def fossils: Future[NonEmptyList[Currency]] =
    getByCurrencyType("Fossil")

  def resonators: Future[NonEmptyList[Currency]] =
    getByCurrencyType("Resonator")

  def orbs: Future[NonEmptyList[Currency]] =
    getByCurrencyType("Orb")

  def vials: Future[NonEmptyList[Currency]] =
    getByCurrencyType("Vial")

  def prophecies: Future[NonEmptyList[Currency]] =
    getByCurrencyType("Prophecy")
}
