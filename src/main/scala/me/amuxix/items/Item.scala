package me.amuxix.items

import me.amuxix._
import me.amuxix.conditions.Condition

import scala.concurrent.Future

abstract class Item extends GenericItem with Named with ImplicitConversions {
  val name: String
  val dropLevel: Int
  val dropEnabled: Boolean

  val `class`: String

  override def condition: Future[Condition] = Future.successful(Condition(
    `class` = `class`,
    base = name,
  ))
}
