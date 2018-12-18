package me.amuxix.items.currency

sealed abstract class Vial extends Currency(10)

object Vial {
  val vials = Seq(
    VialOfAwakening,
    VialOfConsequence,
    VialOfDominance,
    VialOfFate,
    VialOfSacrifice,
    VialOfSummoning,
    VialOfTheGhost,
    VialOfTheRitual,
    VialOfTranscendence,
  )
}

case object VialOfAwakening extends Vial
case object VialOfConsequence extends Vial
case object VialOfDominance extends Vial
case object VialOfFate extends Vial
case object VialOfSacrifice extends Vial
case object VialOfSummoning extends Vial
case object VialOfTheGhost extends Vial
case object VialOfTheRitual extends Vial
case object VialOfTranscendence extends Vial
