package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.CurrencyFragment

class CurrencyFragmentsTable(tag: Tag) extends Table[CurrencyFragment](tag, "currency_fragments") with CommonColumns[CurrencyFragment] {
  def fragmentOf = column[String]("fragment_of")
  def stackSize = column[Int]("stack_size")

  override def * = (
    name,
    fragmentOf,
    stackSize,
    dropEnabled,
  ).mapTo[CurrencyFragment]
}

object CurrencyFragments extends BasicOperations[CurrencyFragment, CurrencyFragmentsTable](new CurrencyFragmentsTable(_))
