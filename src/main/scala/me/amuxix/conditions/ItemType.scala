package me.amuxix.conditions
import me.amuxix.Writable

abstract class ItemType(is: Boolean) extends Writable {
  override protected def print = s"${getClass.getSimpleName} $is"

}
