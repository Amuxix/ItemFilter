package me.amuxix.items

import me.amuxix.conditions.{Condition, ItemClass}

abstract class Item(height: Int, width: Int, val `class`: String) extends GenItem with ProviderPrice {
  lazy val itemClass: ItemClass = ItemClass(`class`)

  val area: Int = height * width

  override def condition: Condition = Condition(
    `class` = Some(itemClass),
    base = name,
    /*height = height,
    width = width*/
  )
}
