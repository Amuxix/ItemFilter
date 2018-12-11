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
    height: Option[Height] = None,
    width: Option[Width] = None,
    gemLevel: Option[GemLevel] = None,
    mapTier: Option[MapTier] = None,
    explicitMod: Option[ExplicitMod] = None,
    shapedMap: Option[ShapedMap] = None,
    identified: Option[Identified] = None,
    corrupted: Option[Corrupted] = None,
    shaperItem: Option[ShaperItem] = None,
    elderItem: Option[ElderItem] = None,
    socketGroup: Option[SocketGroup] = None,
) extends Mergeable[Condition] {
  val conditions: Seq[Writable] = Seq(
    base,
    `class`,
    dropLevel,
    itemLevel,
    quality,
    rarity,
    sockets,
    linkedSockets,
    height,
    width,
    gemLevel,
    mapTier,
    explicitMod,
    shapedMap,
    identified,
    corrupted,
    shaperItem,
    elderItem,
    socketGroup,
  ).collect { case Some(writable) => writable }
  
  private def mergeOptions[T <: Mergeable[T], R](o1: Option[T], o2: Option[T]): Option[T] = {
    for {
      m1 <- o1
      m2 <- o2
    } yield m1 merge m2
  }

  private def canMergeOptions[T <: Mergeable[T], R](o1: Option[T], o2: Option[T]): Boolean = {
    (for {
      m1 <- o1
      m2 <- o2
    } yield m1 canMerge m2).getOrElse(false)
  }

  override def canMerge(o: Condition): Boolean =
    canMergeOptions(base, o.base) &&
      canMergeOptions(`class`, o.`class`) &&
      canMergeOptions(dropLevel, o.dropLevel) &&
      canMergeOptions(itemLevel, o.itemLevel) &&
      canMergeOptions(quality, o.quality) &&
      canMergeOptions(rarity, o.rarity) &&
      canMergeOptions(sockets, o.sockets) &&
      canMergeOptions(linkedSockets, o.linkedSockets) &&
      canMergeOptions(height, o.height) &&
      canMergeOptions(width, o.width) &&
      canMergeOptions(gemLevel, o.gemLevel) &&
      canMergeOptions(mapTier, o.mapTier) &&
      canMergeOptions(explicitMod, o.explicitMod) &&
      shapedMap.size == o.shapedMap.size &&
      identified.size == o.identified.size &&
      corrupted.size == o.corrupted.size &&
      shaperItem.size == o.shaperItem.size &&
      elderItem.size == o.elderItem.size &&
      socketGroup == o.socketGroup

  override def merge(o: Condition): Condition = 
    Condition(
      mergeOptions(base, o.base),
      mergeOptions(`class`, o.`class`),
      mergeOptions(dropLevel, o.dropLevel),
      mergeOptions(itemLevel, o.itemLevel),
      mergeOptions(quality, o.quality),
      mergeOptions(rarity, o.rarity),
      mergeOptions(sockets, o.sockets),
      mergeOptions(linkedSockets, o.linkedSockets),
      mergeOptions(height, o.height),
      mergeOptions(width, o.width),
      mergeOptions(gemLevel, o.gemLevel),
      mergeOptions(mapTier, o.mapTier),
      mergeOptions(explicitMod, o.explicitMod),
      shapedMap.orElse(o.shapedMap),
      identified.orElse(o.identified),
      corrupted.orElse(o.corrupted),
      shaperItem.orElse(o.shaperItem),
      elderItem.orElse(o.elderItem),
      socketGroup,
    )
}
