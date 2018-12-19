package me.amuxix.items.bases.accessories

import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Accessory

sealed abstract class Amulet(dropLevel: Int) extends Accessory(dropLevel, "Amulet")

object Amulet extends FilterClass[Amulet] {
  override val all: Seq[Amulet] = Seq(
    CoralAmulet,
    PauaAmulet,
    AmberAmulet,
    JadeAmulet,
    LapisAmulet,
    GoldAmulet,
    AgateAmulet,
    CitrineAmulet,
    TurquoiseAmulet,
    OnyxAmulet,
    MarbleAmulet,
    BluePearlAmulet,
  )
}

case object CoralAmulet extends Amulet(dropLevel = 1)
case object PauaAmulet extends Amulet(dropLevel = 1)
case object AmberAmulet extends Amulet(dropLevel = 5)
case object JadeAmulet extends Amulet(dropLevel = 5)
case object LapisAmulet extends Amulet(dropLevel = 5)
case object GoldAmulet extends Amulet(dropLevel = 8)
case object AgateAmulet extends Amulet(dropLevel = 16)
case object CitrineAmulet extends Amulet(dropLevel = 16)
case object TurquoiseAmulet extends Amulet(dropLevel = 16)
case object OnyxAmulet extends Amulet(dropLevel = 20)
case object MarbleAmulet extends Amulet(dropLevel = 74)
case object BluePearlAmulet extends Amulet(dropLevel = 77)
