package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.IncursionItem

class IncursionItemsTable(tag: Tag) extends Table[IncursionItem](tag, "incursion_items") with CommonColumns[IncursionItem] {
  override def * =
    (
      name,
      dropEnabled,
    ).mapTo[IncursionItem]
}
object IncursionItems extends BasicOperations[IncursionItem, IncursionItemsTable](new IncursionItemsTable(_))
