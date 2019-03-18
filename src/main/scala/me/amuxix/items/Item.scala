package me.amuxix.items

import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter.ec
import me.amuxix.conditions.{Condition, ItemClass}

import scala.concurrent.Future

abstract class Item(name: String, val height: Int, val width: Int, val `class`: String, dropEnabled: Boolean) extends GenItem(name, dropEnabled) with ProviderPrice {
  lazy val itemClass: ItemClass = ItemClass(`class`)

  lazy val area: OptionT[Future, Int] = OptionT.some[Future](height * width)

  override lazy val condition: Future[Condition] = Future.successful(Condition(
    `class` = Some(itemClass),
    base = name,
  ))
}
