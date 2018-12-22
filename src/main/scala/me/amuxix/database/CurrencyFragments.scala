package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.{Currency, CurrencyFragment}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class CurrencyFragmentsTable(tag: Tag) extends Table[CurrencyFragment](tag, "currency_fragments") with NamedTable[CurrencyFragment] {
  implicit def essenceColumnType = MappedColumnType.base[Currency, String](
    _.name,
    name => Await.result(Currencies.getByName(name), Duration.Inf)
  )

  def fragmentOf = column[Currency]("fragment_of")
  def stackSize = column[Int]("stack_size")

  override def * = (
    name,
    fragmentOf,
    stackSize,
  ) <> ((CurrencyFragment.apply _).tupled, CurrencyFragment.unapply)
}

object CurrencyFragments extends BasicOperations[CurrencyFragment, CurrencyFragmentsTable](new CurrencyFragmentsTable(_))
