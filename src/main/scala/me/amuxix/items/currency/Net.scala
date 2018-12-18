package me.amuxix.items.currency
import me.amuxix.items.NoPrice

sealed abstract class Net extends Currency(100) with NoPrice

object Net {
  val nets: Seq[Net] = Seq(
    SimpleRopeNet,
    StrongRopeNet,
    SimpleIronNet,
    ReinforcedIronNet,
    StrongIronNet,
    SimpleSteelNet,
    ReinforcedSteelNet,
    StrongSteelNet,
    ThaumaturgicalNet,
    ReinforcedRopeNet,
    NecromancyNet,
  )
}

case object SimpleRopeNet extends Net
case object StrongRopeNet extends Net
case object SimpleIronNet extends Net
case object ReinforcedIronNet extends Net
case object StrongIronNet extends Net
case object SimpleSteelNet extends Net
case object ReinforcedSteelNet extends Net
case object StrongSteelNet extends Net
case object ThaumaturgicalNet extends Net
case object ReinforcedRopeNet extends Net
case object NecromancyNet extends Net