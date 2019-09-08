package me.amuxix.database

import cats.data.NonEmptyList
import cats.effect.IO
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
      case Currency.Net    => Net(name, dropEnabled)
      case Currency.Orb    => Orb(name, stackSize, dropEnabled)
      case Currency.Vial   => Vial(name, dropEnabled)
      case Currency.Fossil => Fossil(name, dropEnabled)
      case Currency.Oil    => Oil(name, dropEnabled)
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

object Currencies extends BasicOperations[Currency, CurrenciesTable](new CurrenciesTable(_)) {
  private def getByCurrencyType[Type](currencyType: CurrencyType): IO[NonEmptyList[Type]] =
    all.map(items => items.filter(_.className == currencyType.toString).sortBy(_.dropLevel).map(_.asInstanceOf[Type])) map {
      case Nil          => throw new MatchError(s"Found 0 currencies of $currencyType")
      case head :: tail => NonEmptyList(head, tail)
    }

  lazy val nets: IO[NonEmptyList[Net]] =
    getByCurrencyType(Currency.Net)

  lazy val orbs: IO[NonEmptyList[Orb]] =
    getByCurrencyType(Currency.Orb)

  lazy val vials: IO[NonEmptyList[Vial]] =
    getByCurrencyType(Currency.Vial)

  lazy val fossils: IO[NonEmptyList[Fossil]] =
    getByCurrencyType(Currency.Fossil)

  lazy val oils: IO[NonEmptyList[Oil]] =
    getByCurrencyType(Currency.Oil)
}
