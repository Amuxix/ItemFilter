package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.DivinationCard

class DivinationCardsTable(tag: Tag) extends Table[DivinationCard](tag, "divination_cards") with NamedTable[DivinationCard] {
  override def * = name <> (DivinationCard.apply, DivinationCard.unapply)
}

object DivinationCards extends BasicOperations[DivinationCard, DivinationCardsTable](new DivinationCardsTable(_))
