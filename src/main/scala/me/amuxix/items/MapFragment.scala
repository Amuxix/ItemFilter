package me.amuxix.items

import me.amuxix.conditions.Condition

import scala.concurrent.Future

case class MapFragment(_name: String, fragmentType: String, _dropEnabled: Boolean) extends Item(_name, 1, 1, "Currency", _dropEnabled) {
  override lazy val condition: Future[Condition] = Future.successful(Condition(base = _name))
}
