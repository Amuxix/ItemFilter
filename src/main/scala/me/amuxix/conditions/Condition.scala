package me.amuxix.conditions

import me.amuxix.{Mergeable, Writable}

case class Condition(
    base: Option[BaseType] = None,
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
    elderItem: Option[ElderItem] = None,
    gemLevel: Option[GemLevel] = None)
      extends Mergeable[Condition] {
  val conditions: Seq[Writable] = Seq(
    base,
    `class`,
    dropLevel,
    itemLevel,
    quality,
    rarity,
    sockets,
    linkedSockets,
    socketGroup,
    height,
    width,
    identified,
    corrupted,
    shapedMap,
    shaperItem,
    elderItem,
    gemLevel
  ).collect { case Some(writable) => writable }

  override def canMerge(o: Condition): Boolean =
    `class` == o.`class` &&
      dropLevel == o.dropLevel &&
      itemLevel == o.itemLevel &&
      quality == o.quality &&
      rarity == o.rarity &&
      sockets == o.sockets &&
      linkedSockets == o.linkedSockets &&
      socketGroup == o.socketGroup &&
      height == o.height &&
      width == o.width &&
      identified == o.identified &&
      corrupted == o.corrupted &&
      shapedMap == o.shapedMap &&
      shaperItem == o.shaperItem &&
      elderItem == o.elderItem &&
      gemLevel == o.gemLevel

  override def merge(o: Condition): Condition = {
    val mergedBase: Option[BaseType] = (base, o.base) match {
      case (_, None)                                => None
      case (None, _)                                => None
      case (Some(BaseType(b1)), Some(BaseType(b2))) => Some(BaseType(b1 ++ b2))
    }
    Condition(
      mergedBase,
      `class`,
      dropLevel,
      itemLevel,
      quality,
      rarity,
      sockets,
      linkedSockets,
      socketGroup,
      height,
      width,
      identified,
      corrupted,
      shapedMap,
      shaperItem,
      elderItem,
      gemLevel
    )
  }
}
