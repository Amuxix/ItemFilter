package me.amuxix.stashtabs

case class StashPayload (
  next_change_id: String,
  stashes: List[Stash]
)