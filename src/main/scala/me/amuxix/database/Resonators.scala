package me.amuxix.database

import me.amuxix.database.PostgresProfile.API._
import me.amuxix.items.currency.Resonator

class ResonatorsTable(tag: Tag) extends Table[Resonator](tag, "resonators") with CommonColumns[Resonator] {
  def reforges = column[Boolean]("reforges")
  override def * =
    (
      name,
      reforges,
      dropEnabled,
    ).mapTo[Resonator]
}

object Resonators extends BasicOperations[Resonator, ResonatorsTable](new ResonatorsTable(_))
