package me.amuxix

final case class DatabaseConfiguration(
  driver: String,
  user: String,
  password: String,
  url: String
)

final case class FilterConfiguration(
  threshold: Double,
  levelCutoffs: Cutoffs,
  weaponClasses: List[String],
  armourClasses: List[String],
  accessoriesClasses: List[String],
  shieldClasses: List[String],
  flaskClasses: List[String],
)

final case class Cutoffs(
  normalItems: Int,
  magicItems: Int,
  fourLinkRare: Int,
  setArmourDropLevel: Int,
  bestBaseMinDropLevel: Int,
)