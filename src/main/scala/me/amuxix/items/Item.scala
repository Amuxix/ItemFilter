package me.amuxix.items

import me.amuxix.conditions.{Condition, ItemClass}

import scala.concurrent.Future

abstract class Item(name: String, val height: Int, val width: Int, val `class`: String, dropEnabled: Boolean) extends GenItem(name, dropEnabled) with ProviderPrice {
  lazy val itemClass: ItemClass = ItemClass(`class`)

  val area: Int = height * width

  override lazy val condition: Future[Condition] = Future.successful(Condition(
    `class` = Some(itemClass),
    base = name,
  ))
}
