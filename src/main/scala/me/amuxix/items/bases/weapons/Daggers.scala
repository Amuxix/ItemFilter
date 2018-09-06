package me.amuxix.items.bases.weapons

import me.amuxix.items.Size
import me.amuxix.items.bases.Weapon

sealed abstract class Dagger(dropLevel: Int) extends Weapon(Size(3, 1), dropLevel, "Dagger")

object GlassShank extends Dagger(dropLevel = 1)
object SkinningKnife extends Dagger(dropLevel = 5)
object CarvingKnife extends Dagger(dropLevel = 10)
object Stiletto extends Dagger(dropLevel = 15)
object BootKnife extends Dagger(dropLevel = 20)
object CopperKris extends Dagger(dropLevel = 24)
object Skean extends Dagger(dropLevel = 28)
object ImpDagger extends Dagger(dropLevel = 32)
object FlayingKnife extends Dagger(dropLevel = 35)
object ProngDagger extends Dagger(dropLevel = 36)
object ButcherKnife extends Dagger(dropLevel = 38)
object Poignard extends Dagger(dropLevel = 41)
object BootBlade extends Dagger(dropLevel = 44)
object GoldenKris extends Dagger(dropLevel = 47)
object RoyalSkean extends Dagger(dropLevel = 50)
object FiendDagger extends Dagger(dropLevel = 53)
object Trisula extends Dagger(dropLevel = 55)
object GuttingKnife extends Dagger(dropLevel = 56)
object SlaughterKnife extends Dagger(dropLevel = 58)
object Ambusher extends Dagger(dropLevel = 60)
object EzomyteDagger extends Dagger(dropLevel = 62)
object PlatinumKris extends Dagger(dropLevel = 64)
object ImperialSkean extends Dagger(dropLevel = 66)
object DemonDagger extends Dagger(dropLevel = 68)
object Sai extends Dagger(dropLevel = 70)
