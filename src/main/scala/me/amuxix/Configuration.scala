package me.amuxix

import com.typesafe.config.{Config, ConfigFactory}
import org.http4s.Uri
import pureconfig.{ConfigConvert, ConfigSource}
import pureconfig.generic.auto._
import pureconfig.ConfigConvert.viaNonEmptyStringTry

final case class DatabaseConfiguration(
  driver: String,
  user: String,
  password: String,
  url: String
)

final case class Cutoffs(
  normalItems: Int,
  magicItems: Int,
  fourLinkRare: Int,
  setArmourDropLevel: Int,
  bestBaseMinDropLevel: Int,
)

final case class GGG(
  uri: Uri,
  cookie: String,
  racingId: String,
  normalId: String,
  diminishedId: String,
  reducedId: String,
)

final case class FilterSettings(
  threshold: Double,
  levelCutoffs: Cutoffs,
  ggg: GGG,
  weaponClasses: List[String],
  armourClasses: List[String],
  accessoriesClasses: List[String],
  shieldClasses: List[String],
  flaskClasses: List[String],
)

object FilterSettings {
  implicit val http4sUriConfigConvert: ConfigConvert[Uri] = viaNonEmptyStringTry[Uri](Uri.fromString(_).toTry, _.toString)
  def fromConfig(config: Config = ConfigFactory.load()): FilterSettings = ConfigSource.fromConfig(config).at("filter").loadOrThrow[FilterSettings]
}

