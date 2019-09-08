package me.amuxix.database

import com.github.tminglei.slickpg._
import me.amuxix.database.types.{Currency, Item, MapFragment}
import me.amuxix.database.types.Currency.CurrencyType
import me.amuxix.database.types.Item.ItemType
import me.amuxix.database.types.MapFragment.MapFragmentType

trait PostgresProfile extends ExPostgresProfile with PgArraySupport with PgDateSupport with PgDate2Support {

  object API extends super.API
                     with ArrayImplicits
                     with SimpleDateTimeImplicits
                     with DateTimeImplicits
                     with Date2DateTimePlainImplicits {
    implicit val mapFragmentTypeMapper =
      MappedColumnType.base[MapFragmentType, String](
        e => e.toString,
        s => MapFragment.withName(s)
      )
    implicit val currencyTypeMapper = MappedColumnType.base[CurrencyType, String](
      e => e.toString,
      s => Currency.withName(s)
    )
    implicit val itemTypeMapper = MappedColumnType.base[ItemType, String](
      _.toString,
      Item.withName
    )
  }
}

object PostgresProfile extends PostgresProfile
