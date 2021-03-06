package me.amuxix.database

import me.amuxix.database.PostgresProfile.API._
import me.amuxix.items.currency.Essence

class EssencesTable(tag: Tag) extends Table[Essence](tag, "essences") with CommonColumns[Essence] {
  def upgradesTo = column[String]("upgrades_to")

  override def * =
    (
      name,
      upgradesTo.?,
      dropEnabled,
    ).mapTo[Essence]
}
object Essences extends BasicOperations[Essence, EssencesTable](new EssencesTable(_))
