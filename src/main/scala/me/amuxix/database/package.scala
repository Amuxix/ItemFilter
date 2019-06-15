package me.amuxix

import me.amuxix.database.types.{Currency, Item, MapFragment}
import me.amuxix.database.types.MapFragment.MapFragmentType
import me.amuxix.database.PostgresProfile.api._
import me.amuxix.database.types.Currency.CurrencyType
import me.amuxix.database.types.Item.ItemType

package object database {
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
