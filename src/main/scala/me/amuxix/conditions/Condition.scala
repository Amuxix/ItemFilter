package me.amuxix.conditions

import me.amuxix.{Mergeable, Writable}

//TODO Separate into two argument lists, one for properties fixed by base(class, baseType, height and width) and one for the rest.
//TODO Accept an option of base instead of first argument list
case class Condition(
  `class`: Option[ItemClass] = None,
  base: Option[BaseType] = None,
  prophecy: Option[Prophecy] = None,
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
  influence: Option[HasInfluence] = None,
  fracturedItem: Option[FracturedItem] = None,
  synthesisedItem: Option[SynthesisedItem] = None,
  anyEnchantment: Option[AnyEnchantment] = None,
  socketGroup: Option[SocketGroup] = None,
) extends Mergeable[Condition] {

  val conditions: Seq[Writable] = Seq(
    `class`,
    base,
    prophecy,
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
    influence,
    fracturedItem,
    synthesisedItem,
    anyEnchantment,
    socketGroup,
  ).flatten

  private def mergeOptions[T <: Mergeable[T]](o1: Option[T], o2: Option[T]): Option[T] =
    (o1, o2) match {
      case (Some(m1), Some(m2)) => Some(m1 merge m2)
      case (None, None)         => None
      case _ =>
        println(o1)
        println(o2)
        println(canMergeOptions(o1, o2))
        throw new Exception("Attempting to merge un-mergeable things.")
    }

  private def canMergeOptions[T <: Mergeable[T]](o1: Option[T], o2: Option[T]): Boolean =
    (o1, o2) match {
      case (Some(m1), Some(m2)) => m1 canMerge m2
      case (None, None)         => true
      case _                    => false
    }

  private def mergeBooleanOption[T](o1: Option[T], o2: Option[T]): Option[T] =
    if (o1 == o2) o1
    else None

  override def canMerge(o: Condition): Boolean =
    canMergeOptions(`class`, o.`class`) &&
      canMergeOptions(base, o.base) &&
      canMergeOptions(prophecy, o.prophecy) &&
      canMergeOptions(dropLevel, o.dropLevel) &&
      itemLevel == o.itemLevel &&
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
      canMergeOptions(influence, o.influence) &&
      fracturedItem == o.fracturedItem &&
      synthesisedItem == o.synthesisedItem &&
      anyEnchantment == o.anyEnchantment &&
      socketGroup == o.socketGroup

  override def merge(o: Condition): Condition =
    Condition(
      `class` = mergeOptions(`class`, o.`class`),
      base = mergeOptions(base, o.base),
      prophecy = mergeOptions(prophecy, o.prophecy),
      dropLevel = mergeOptions(dropLevel, o.dropLevel),
      itemLevel = itemLevel,
      quality = mergeOptions(quality, o.quality),
      rarity = mergeOptions(rarity, o.rarity),
      sockets = mergeOptions(sockets, o.sockets),
      linkedSockets = mergeOptions(linkedSockets, o.linkedSockets),
      height = mergeOptions(height, o.height),
      width = mergeOptions(width, o.width),
      gemLevel = mergeOptions(gemLevel, o.gemLevel),
      mapTier = mergeOptions(mapTier, o.mapTier),
      explicitMod = mergeOptions(explicitMod, o.explicitMod),
      stackSize = mergeOptions(stackSize, o.stackSize),
      shapedMap = mergeBooleanOption(shapedMap, o.shapedMap),
      identified = mergeBooleanOption(identified, o.identified),
      corrupted = mergeBooleanOption(corrupted, o.corrupted),
      influence = mergeOptions(influence, o.influence),
      fracturedItem = mergeBooleanOption(fracturedItem, o.fracturedItem),
      synthesisedItem = mergeBooleanOption(synthesisedItem, o.synthesisedItem),
      anyEnchantment = mergeBooleanOption(anyEnchantment, o.anyEnchantment),
      socketGroup = socketGroup,
    )

  def join(o: Condition): Condition =
    Condition(
      `class` = `class`.orElse(o.`class`),
      base = base.orElse(o.base),
      prophecy = prophecy.orElse(o.prophecy),
      dropLevel = dropLevel.orElse(o.dropLevel),
      itemLevel = itemLevel.orElse(o.itemLevel),
      quality = quality.orElse(o.quality),
      rarity = rarity.orElse(o.rarity),
      sockets = sockets.orElse(o.sockets),
      linkedSockets = linkedSockets.orElse(o.linkedSockets),
      height = height.orElse(o.height),
      width = width.orElse(o.width),
      gemLevel = gemLevel.orElse(o.gemLevel),
      mapTier = mapTier.orElse(o.mapTier),
      explicitMod = explicitMod.orElse(o.explicitMod),
      stackSize = stackSize.orElse(o.stackSize),
      shapedMap = shapedMap.orElse(o.shapedMap),
      identified = identified.orElse(o.identified),
      corrupted = corrupted.orElse(o.corrupted),
      influence = influence.orElse(o.influence),
      fracturedItem = fracturedItem.orElse(o.fracturedItem),
      synthesisedItem = synthesisedItem.orElse(o.synthesisedItem),
      anyEnchantment = anyEnchantment.orElse(o.anyEnchantment),
      socketGroup = socketGroup.orElse(o.socketGroup),
    )
}
