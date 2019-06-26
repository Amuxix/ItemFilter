package me.amuxix.stashtabs

import play.api.libs.json.{Json, OFormat}

case class Item (
  verified: Boolean,
  //w: Int,
  //h: Int,
  ilvl: Int,
  //icon: String,
  league: String,
  //id: String,
  name: String,
  typeLine: String,
  identified: Boolean,
  //properties: Seq[Properties],
  //explicitMods: Option[Seq[String]],
  //descrText: Option[String],
  //frameType: Int,
  //stackSize: Option[Int],
  //maxStackSize: Option[Int],
  //category: Category,
  //x: Int,
  //y: Int,
  //inventoryId: String,
  note: Option[String],
  //sockets: Option[Seq[Sockets]],
  corrupted: Option[Boolean],
  //requirements: Option[Seq[Properties]],
  implicitMods: Option[List[String]],
  //flavourText: Option[Seq[String]],
  //socketedItems: Option[Seq[SocketedItems]]
)

object Item {
  implicit val format: OFormat[Item] = Json.format[Item]
}