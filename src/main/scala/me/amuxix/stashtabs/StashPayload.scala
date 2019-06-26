package me.amuxix.stashtabs

import play.api.libs.json.{Json, OFormat}

case class StashPayload (
  next_change_id: String,
  stashes: List[Stash]
)

object StashPayload {
  implicit val format: OFormat[StashPayload] = Json.format[StashPayload]
}