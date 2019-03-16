package me.amuxix.items

import me.amuxix.conditions.{Condition, ItemClass}

abstract class Item(name: String, val height: Int, val width: Int, val `class`: String) extends GenItem(name) with ProviderPrice {
  lazy val itemClass: ItemClass = ItemClass(`class`)

  val area: Int = height * width

  override def condition: Condition = Condition(
    `class` = Some(itemClass),
    base = name,
  )
}
