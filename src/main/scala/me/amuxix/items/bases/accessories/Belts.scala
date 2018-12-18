package me.amuxix.items.bases.accessories

import me.amuxix.items.bases.Accessory

sealed abstract class Belt(dropLevel: Int) extends Accessory(dropLevel, "Belt")

case object ChainBelt extends Belt(dropLevel = 1)
case object RusticSash extends Belt(dropLevel = 1)
case object StygianVise extends Belt(dropLevel = 1)
case object HeavyBelt extends Belt(dropLevel = 8)
case object LeatherBelt extends Belt(dropLevel = 8)
case object ClothBelt extends Belt(dropLevel = 16)
case object StuddedBelt extends Belt(dropLevel = 16)
case object VanguardBelt extends Belt(dropLevel = 78)
case object CrystalBelt extends Belt(dropLevel = 79)
