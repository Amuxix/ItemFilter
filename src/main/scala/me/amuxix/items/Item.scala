package me.amuxix.items

import me.amuxix.Named
import me.amuxix.conditions.{BaseType, DropLevel, ItemClass}

abstract case class Item(dropLevel: DropLevel, `class`: ItemClass) extends Named {
  def this(level: Int, `class`: String) = this(DropLevel(level), ItemClass(`class`))

  val baseType: BaseType = BaseType(name.replaceAll("([a-z])([A-Z])", "$1 $2"))
}