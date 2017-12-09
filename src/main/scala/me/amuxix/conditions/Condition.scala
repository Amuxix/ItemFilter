package me.amuxix.conditions

import me.amuxix.Writable

/*object Condition {
  def apply(cenas: Writable*): Condition = {
    var baseType = Option.empty[BaseType]
    var `class` = Option.empty[ItemClass]
    var dropLevel = Option.empty[DropLevel]
    var itemLevel = Option.empty[ItemLevel]
    var quality = Option.empty[Quality]
    var rarity = Option.empty[Rarity]
    var sockets = Option.empty[Sockets]
    var linkedSockets = Option.empty[LinkedSockets]
    var socketGroup = Option.empty[SocketGroup]
    var height = Option.empty[Height]
    var width = Option.empty[Width]
    var identified = Option.empty[Identified]
    var corrupted = Option.empty[Corrupted]
    var shapedMap = Option.empty[ShapedMap]
    var shaperItem = Option.empty[ShaperItem]
    var elderItem: Option[ElderItem] = None
    cenas.foreach {
      case base: BaseType => baseType = Some(base)
      case cls: ItemClass => `class` = Some(cls)
      case dropLevel: DropLevel => Some(dropLevel)
      case itemLevel: ItemLevel => Some(itemLevel)
      case quality: Quality => Some(quality)
      case rarity: Rarity => Some(rarity)
      case sockets: Sockets => Some(sockets)
      case linkedSockets: LinkedSockets => Some(linkedSockets)
      case socketGroup: SocketGroup => Some(socketGroup)
      case height: Height => Some(height)
      case width: Width => Some(width)
      case identified: Identified => Some(identified)
      case corrupted: Corrupted => Some(corrupted)
      case shapedMap: ShapedMap => Some(shapedMap)
      case shaperItem: ShaperItem => Some(shaperItem)
      case elderItem: ElderItem => Some(elderItem)
    }
    Condition(baseType)
  }
}*/

case class Condition(base: Option[BaseType] = None,
                     `class`: Option[ItemClass] = None,
                     dropLevel: Option[DropLevel] = None,
                     itemLevel: Option[ItemLevel] = None,
                     quality: Option[Quality] = None,
                     rarity: Option[Rarity] = None,
                     sockets: Option[Sockets] = None,
                     linkedSockets: Option[LinkedSockets] = None,
                     socketGroup: Option[SocketGroup] = None,
                     height: Option[Height] = None,
                     width: Option[Width] = None,
                     identified: Option[Identified] = None,
                     corrupted: Option[Corrupted] = None,
                     shapedMap: Option[ShapedMap] = None,
                     shaperItem: Option[ShaperItem] = None,
                     elderItem: Option[ElderItem] = None) {
  val conditions: Seq[Writable] = Seq(base, `class`, dropLevel, itemLevel, quality, rarity, sockets, linkedSockets,
    socketGroup, height, width, identified, corrupted, shapedMap, shaperItem, elderItem).collect{case Some(writable) => writable}
}

/*object Condition {
  implicit case class Height(tuple: (Operator, Int)) extends Writable {
    require(tuple._2 < 1 || tuple._2 > 4)
    override def print: String = s"Height ${tuple._1.print}${tuple._2}"
  }
  implicit def int2Height(height: Int): Height = new Height(("=", height))
}*/
