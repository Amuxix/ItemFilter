package me.amuxix.items
import me.amuxix.items.Variant.Variation

object Variant extends Enumeration {
  type Variation = Value
  val Shaper = Value
  val Elder = Value
}

trait Variations {
  val variant: Option[Variation]
}
