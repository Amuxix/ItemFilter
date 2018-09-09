package me.amuxix.items.bases.accessories

import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.items.bases.Accessory

sealed abstract class Amulet(dropLevel: Int) extends Accessory(dropLevel, "Amulet")

object CoralAmulet extends Amulet(dropLevel = 1)
object PauaAmulet extends Amulet(dropLevel = 1)
object AmberAmulet extends Amulet(dropLevel = 5)
object JadeAmulet extends Amulet(dropLevel = 5)
object LapisAmulet extends Amulet(dropLevel = 5)
object GoldAmulet extends Amulet(dropLevel = 8)
object AgateAmulet extends Amulet(dropLevel = 16)
object CitrineAmulet extends Amulet(dropLevel = 16)
object TurquoiseAmulet extends Amulet(dropLevel = 16)
object OnyxAmulet extends Amulet(dropLevel = 20)
object MarbleAmulet extends Amulet(dropLevel = 74)
object BluePearlAmulet extends Amulet(dropLevel = 77)
