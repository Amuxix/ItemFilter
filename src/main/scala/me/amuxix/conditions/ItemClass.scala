package me.amuxix.conditions

import me.amuxix.Writable.addQuotesIfMultiWorded
import me.amuxix.{Default, InvalidArgument, RefEquals}


object ItemClass extends Default[ItemClass] {
  /** *
    * This specifies a default value of the T type, it doesn't really matter what it's value is as
    * will only compared by reference
    */
  override val default = ItemClass("")
}

case class ItemClass(clazz: String) extends BaseCondition with RefEquals {
  if (clazz == "") throw new InvalidArgument
  override def print: String = s"Class ${addQuotesIfMultiWorded(clazz)}"
}