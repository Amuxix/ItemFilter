package me.amuxix.items
import me.amuxix.conditions.Condition

import scala.concurrent.Future

case class Prophecy(_name: String, _dropEnabled: Boolean) extends Item(_name, 1, 1, "Currency", _dropEnabled) {
  override lazy val condition: Future[Condition] = Future.successful(Condition(
    `class` = Some(itemClass),
    base = "Prophecy",
    prophecy = _name
  ))
}