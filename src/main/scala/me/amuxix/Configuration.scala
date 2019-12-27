package me.amuxix

import com.typesafe.config.{Config, ConfigFactory}
import pureconfig.ConfigSource
import pureconfig.generic.auto._

final case class DatabaseConfiguration(
  driver: String,
  user: String,
  password: String,
  url: String
)

final case class FilterSettings(
  threshold: Double,
  levelCutoffs: Cutoffs,
  weaponClasses: List[String],
  armourClasses: List[String],
  accessoriesClasses: List[String],
  shieldClasses: List[String],
  flaskClasses: List[String],
)

object FilterSettings {
  def fromConfig(config: Config = ConfigFactory.load()): FilterSettings = ConfigSource.fromConfig(config).at("filter").loadOrThrow[FilterSettings]
}

final case class Cutoffs(
  normalItems: Int,
  magicItems: Int,
  fourLinkRare: Int,
  setArmourDropLevel: Int,
  bestBaseMinDropLevel: Int,
)
