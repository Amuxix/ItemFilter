package me.amuxix.database

import me.amuxix.database.PostgresProfile.API._
import me.amuxix.items.Watchstone

class WatchstonesTable(tag: Tag) extends Table[Watchstone](tag, "watchstones") with CommonColumns[Watchstone] {
  override def * =
    (
      name,
      dropEnabled,
      ).mapTo[Watchstone]
}

object Watchstones extends BasicOperations[Watchstone, WatchstonesTable](new WatchstonesTable(_))
