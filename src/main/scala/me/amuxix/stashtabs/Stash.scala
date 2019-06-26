package me.amuxix.stashtabs

import play.api.libs.json.{Json, OFormat}

case class Stash (
  id: String,
  public: Boolean,
  accountName: Option[String],
  lastCharacterName: Option[String],
  stash: Option[String], //Stash name
  league: Option[String],
  items: List[Item]
)

object Stash {
  implicit val format: OFormat[Stash] = Json.format[Stash]
}