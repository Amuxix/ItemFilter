package me.amuxix.database

import me.amuxix.database.PostgresProfile.API._
import me.amuxix.items.DivinationCard

class DivinationCardsTable(tag: Tag) extends Table[DivinationCard](tag, "divination_cards") with CommonColumns[DivinationCard] {
  override def * =
    (
      name,
      dropEnabled,
    ).mapTo[DivinationCard]
}

object DivinationCards extends BasicOperations[DivinationCard, DivinationCardsTable](new DivinationCardsTable(_))
