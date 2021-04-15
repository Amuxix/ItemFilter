package me.amuxix.database

import me.amuxix.database.types.Currency.CurrencyType
import me.amuxix.database.PostgresProfile.API._
import me.amuxix.database.types.Currency
import me.amuxix.items.Currency
import me.amuxix.items.currency._

class CurrenciesTable(tag: Tag) extends Table[Currency](tag, "currency") with CommonColumns[Currency] {
  def stackSize = column[Int]("stack_size")
  def currencyType = column[CurrencyType]("currency_type")

  private def currencyFactory(
    name: String,
    stackSize: Int,
    currencyType: CurrencyType,
    dropEnabled: Boolean
  ): Currency =
    currencyType match {
      case Currency.Net      => Net(name, dropEnabled)
      case Currency.Orb      => Orb(name, stackSize, dropEnabled)
      case Currency.Vial     => Vial(name, dropEnabled)
      case Currency.Fossil   => Fossil(name, dropEnabled)
      case Currency.Oil      => Oil(name, dropEnabled)
      case Currency.Catalyst => Catalyst(name, dropEnabled)
      case Currency.DeliriumOrb => DeliriumOrb(name, stackSize, dropEnabled)
    }

  def unapply(currency: Currency): Option[(String, Int, CurrencyType, Boolean)] = ???

  override def * =
    (
      name,
      stackSize,
      currencyType,
      dropEnabled,
    ) <> ((currencyFactory _).tupled, unapply)
}

object Currencies extends BasicOperations[Currency, CurrenciesTable](new CurrenciesTable(_))
