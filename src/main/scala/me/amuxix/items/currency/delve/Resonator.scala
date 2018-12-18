package me.amuxix.items.currency.delve

import me.amuxix.items.currency.Currency

sealed abstract class Resonator extends Currency(1)

object Resonator {
  val resonators: Seq[Resonator] = Seq(
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
