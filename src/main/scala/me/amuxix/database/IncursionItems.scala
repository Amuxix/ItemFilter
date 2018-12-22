package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.IncursionItem

class IncursionItemsTable(tag: Tag) extends Table[IncursionItem](tag, "incursion_items") with NamedTable[IncursionItem] {
  override def * = name <> (IncursionItem.apply, IncursionItem.unapply)
}
object IncursionItems extends BasicOperations[IncursionItem, IncursionItemsTable](new IncursionItemsTable(_))
