package me.amuxix.conditions

import me.amuxix.Writable

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
    if (tuple._2 < 1 || tuple._2 > 4) throw new InvalidArgument
    override def print: String = s"Height ${tuple._1.print}${tuple._2}"
  }
  implicit def int2Height(height: Int): Height = new Height(("=", height))
}*/
