package me.amuxix.items.currency.delve

import me.amuxix.items.Item
import me.amuxix.items.currency.Currency

trait Resonator extends Currency

object Resonator {
  val resonators = Seq[Item](
    PrimeAlchemicalResonator,
    PrimeChaoticResonator,
    PowerfulChaoticResonator,
    PowerfulAlchemicalResonator,
    PotentAlchemicalResonator,
    PotentChaoticResonator,
    PrimitiveAlchemicalResonator,
    PrimitiveChaoticResonator,
  )
}

case object PrimeAlchemicalResonator extends Resonator
case object PrimeChaoticResonator extends Resonator
case object PowerfulChaoticResonator extends Resonator
case object PowerfulAlchemicalResonator extends Resonator
case object PotentAlchemicalResonator extends Resonator
case object PotentChaoticResonator extends Resonator
case object PrimitiveAlchemicalResonator extends Resonator
case object PrimitiveChaoticResonator extends Resonator
