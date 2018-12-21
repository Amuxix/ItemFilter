package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.currency.Currency

import scala.concurrent.Future

object Currencies extends BasicOperations[Currency] {
  type Table = CurrenciesTable
  class CurrenciesTable(tag: Tag) extends NamedTable[Currency](tag, "currency") {
    def stackSize = column[Int]("stack_size")
    def currencyType = column[String]("currency_type")

    override def * = (
      name,
      stackSize,
      currencyType,
    ) <> ((Currency.apply _).tupled, Currency.unapply)
  }

  def fossils: Future[Seq[Currency]] =
    db.run(query.filter(_.currencyType === "Fossil").result)

  def resonators: Future[Seq[Currency]] =
    db.run(query.filter(_.currencyType === "Resonator").result)

  def nets: Future[Seq[Currency]] =
    db.run(query.filter(_.currencyType === "Net").result)

  def orbs: Future[Seq[Currency]] =
    db.run(query.filter(_.currencyType === "Orb").result)

  def vials: Future[Seq[Currency]] =
    db.run(query.filter(_.currencyType === "Vial").result)
}
