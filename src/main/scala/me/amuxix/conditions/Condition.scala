package me.amuxix.conditions

import me.amuxix.{Mergeable, Writable}

//TODO Separate into two argument lists, one for properties fixed by base(class, baseType, height and width) and one for the rest.
//TODO Accept an option of base instead of first argument list
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
    stackSize: Option[StackSize] = None,
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
    stackSize,
    shapedMap,
    identified,
    corrupted,
    shaperItem,
    elderItem,
    socketGroup,
  ).flatten
  
  private def mergeOptions[T <: Mergeable[T]](o1: Option[T], o2: Option[T]): Option[T] =
    (o1, o2) match {
      case (Some(m1), Some(m2)) => Some(m1 merge m2)
      case (None, None) => None
      case _ =>
        println(o1)
        println(o2)
        println(canMergeOptions(o1, o2))
        throw new Exception("Attempting to merge un-mergeable things.")
    }

  private def canMergeOptions[T <: Mergeable[T]](o1: Option[T], o2: Option[T]): Boolean =
    (o1, o2) match {
      case (Some(m1), Some(m2)) => m1 canMerge m2
      case (None, None) => true
      case _ => false
    }

  private def mergeBooleanOption[T](o1: Option[T], o2: Option[T]): Option[T] =
    if (o1 == o2) o1
    else None

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
      canMergeOptions(stackSize, o.stackSize) &&
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
      mergeOptions(stackSize, o.stackSize),
      mergeBooleanOption(shapedMap, o.shapedMap),
      mergeBooleanOption(identified, o.identified),
      mergeBooleanOption(corrupted, o.corrupted),
      mergeBooleanOption(shaperItem, o.shaperItem),
      mergeBooleanOption(elderItem, o.elderItem),
      socketGroup,
    )

  def join(o: Condition): Condition =
    Condition(
      base.orElse(o.base),
      `class`.orElse(o.`class`),
      dropLevel.orElse(o.dropLevel),
      itemLevel.orElse(o.itemLevel),
      quality.orElse(o.quality),
      rarity.orElse(o.rarity),
      sockets.orElse(o.sockets),
      linkedSockets.orElse(o.linkedSockets),
      height.orElse(o.height),
      width.orElse(o.width),
      gemLevel.orElse(o.gemLevel),
      mapTier.orElse(o.mapTier),
      explicitMod.orElse(o.explicitMod),
      stackSize.orElse(o.stackSize),
      shapedMap.orElse(o.shapedMap),
      identified.orElse(o.identified),
      corrupted.orElse(o.corrupted),
      shaperItem.orElse(o.shaperItem),
      elderItem.orElse(o.elderItem),
      socketGroup.orElse(o.socketGroup),
    )
}
