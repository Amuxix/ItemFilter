package me.amuxix.items

import me.amuxix._
import me.amuxix.conditions.Condition

abstract class Item extends GenericItem with Named with ImplicitConversions {
  val name: String
  val dropLevel: Int
  val dropEnabled: Boolean

  val `class`: String
  val itemType: String = className

  override def condition: Condition = Condition(`class` = `class`, base = name)
}
