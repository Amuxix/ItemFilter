package me.amuxix.database

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
  private def getByCurrencyType(currencyType: String) =
    db.run(filter(_.currencyType === currencyType).result)

  def fossils: Future[Seq[Currency]] =
    getByCurrencyType("Fossil")

  def resonators: Future[Seq[Currency]] =
    getByCurrencyType("Resonator")

  def orbs: Future[Seq[Currency]] =
    getByCurrencyType("Orb")

  def vials: Future[Seq[Currency]] =
    getByCurrencyType("Vial")

  def prophecies: Future[Seq[Currency]] =
    getByCurrencyType("Prophecy")
}
