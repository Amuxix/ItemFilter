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

object PrimeAlchemicalResonator extends Resonator
object PrimeChaoticResonator extends Resonator
object PowerfulChaoticResonator extends Resonator
object PowerfulAlchemicalResonator extends Resonator
object PotentAlchemicalResonator extends Resonator
object PotentChaoticResonator extends Resonator
object PrimitiveAlchemicalResonator extends Resonator
object PrimitiveChaoticResonator extends Resonator
