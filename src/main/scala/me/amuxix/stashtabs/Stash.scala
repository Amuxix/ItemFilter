package me.amuxix.stashtabs

case class Stash (
  id: String,
  public: Boolean,
  accountName: Option[String],
  lastCharacterName: Option[String],
  stash: Option[String], //Stash name
  league: Option[String],
  items: List[Item]
)