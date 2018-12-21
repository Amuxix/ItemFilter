package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.currency.{Currency, CurrencyFragment}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object CurrencyFragments extends BasicOperations[CurrencyFragment] {
  implicit def essenceColumnType = MappedColumnType.base[Currency, String](
    _.name,
    name => Await.result(Currencies.getByName(name), Duration.Inf)
  )
  class CurrencyFragmentsTable(tag: Tag) extends NamedTable[CurrencyFragment](tag, "currency_fragments") {
    def fragmentOf = column[Currency]("fragment_of")
    def stackSize = column[Int]("stack_size")

    override def * = (
      name,
      fragmentOf,
      stackSize,
    ) <> ((CurrencyFragment.apply _).tupled, CurrencyFragment.unapply)
  }
}
