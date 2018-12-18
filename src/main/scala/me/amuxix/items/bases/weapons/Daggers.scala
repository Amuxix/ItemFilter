package me.amuxix.items.bases.weapons
import me.amuxix.items.FilterClass
import me.amuxix.items.bases.Weapon

sealed abstract class Dagger(dropLevel: Int) extends Weapon(3, 1, dropLevel, "Dagger")

object Dagger extends FilterClass[Dagger] {
  override val all: Seq[Dagger] = Seq(GlassShank, SkinningKnife, CarvingKnife, Stiletto, BootKnife, CopperKris, Skean, ImpDagger, FlayingKnife, ProngDagger, ButcherKnife, Poignard, BootBlade, GoldenKris, RoyalSkean, FiendDagger, Trisula, GuttingKnife, SlaughterKnife, Ambusher, EzomyteDagger, PlatinumKris, ImperialSkean, DemonDagger, Sai)
}

case object GlassShank extends Dagger(dropLevel = 1)
case object SkinningKnife extends Dagger(dropLevel = 5)
case object CarvingKnife extends Dagger(dropLevel = 10)
case object Stiletto extends Dagger(dropLevel = 15)
case object BootKnife extends Dagger(dropLevel = 20)
case object CopperKris extends Dagger(dropLevel = 24)
case object Skean extends Dagger(dropLevel = 28)
case object ImpDagger extends Dagger(dropLevel = 32)
case object FlayingKnife extends Dagger(dropLevel = 35)
case object ProngDagger extends Dagger(dropLevel = 36)
case object ButcherKnife extends Dagger(dropLevel = 38)
case object Poignard extends Dagger(dropLevel = 41)
case object BootBlade extends Dagger(dropLevel = 44)
case object GoldenKris extends Dagger(dropLevel = 47)
case object RoyalSkean extends Dagger(dropLevel = 50)
case object FiendDagger extends Dagger(dropLevel = 53)
case object Trisula extends Dagger(dropLevel = 55)
case object GuttingKnife extends Dagger(dropLevel = 56)
case object SlaughterKnife extends Dagger(dropLevel = 58)
case object Ambusher extends Dagger(dropLevel = 60)
case object EzomyteDagger extends Dagger(dropLevel = 62)
case object PlatinumKris extends Dagger(dropLevel = 64)
case object ImperialSkean extends Dagger(dropLevel = 66)
case object DemonDagger extends Dagger(dropLevel = 68)
case object Sai extends Dagger(dropLevel = 70)
