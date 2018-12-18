package me.amuxix.items
import me.amuxix.Named

trait FilterClass[+T <: Item] extends Named {
  val className: String = name
  val all: Seq[T]
}
