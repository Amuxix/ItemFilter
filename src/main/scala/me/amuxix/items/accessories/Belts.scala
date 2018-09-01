package me.amuxix.items.accessories

import me.amuxix.items.Accessory

sealed abstract class Belt(dropLevel: Int) extends Accessory(dropLevel, "Belt")

object ChainBelt extends Belt(dropLevel = 1)
object RusticSash extends Belt(dropLevel = 1)
object StygianVise extends Belt(dropLevel = 1)
object HeavyBelt extends Belt(dropLevel = 8)
object LeatherBelt extends Belt(dropLevel = 8)
object ClothBelt extends Belt(dropLevel = 16)
object StuddedBelt extends Belt(dropLevel = 16)
object VanguardBelt extends Belt(dropLevel = 78)
object CrystalBelt extends Belt(dropLevel = 79)
