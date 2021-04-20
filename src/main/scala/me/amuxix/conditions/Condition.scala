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
  alternateQuality: Option[AlternateQuality] = None,
) extends Mergeable[Condition] {

  implicit class MergeableOption[T <: Mergeable[T]](o1: Option[T]) extends Mergeable[Option[T]] {
    override def canMerge(o2: Option[T]): Boolean =
      (o1, o2) match {
        case (Some(m1), Some(m2)) => m1 canMerge m2
        case (None, None)         => true
        case _                    => false
      }

    override def merge(o2: Option[T]): Option[T] =
      (o1, o2) match {
        case (Some(m1), Some(m2)) => Some(m1 merge m2)
        case (None, None)         => None
        case _                    => throw new Exception("Attempting to merge un-mergeable things.")
      }
  }

  protected val operatorConditions: Seq[Option[OperatorWritable[_] with Mergeable[_]]] = Seq(
    dropLevel,
    gemLevel,
    height,
    itemLevel,
    linkedSockets,
    mapTier,
    quality,
    sockets,
    stackSize,
    width,
  )

  protected val otherConditions: Seq[Option[Writable with Mergeable[_]]] = Seq(
    `class`,
    base,
    prophecy,
    rarity,
    explicitMod,
    shapedMap,
    identified,
    corrupted,
    influence,
    fracturedItem,
    synthesisedItem,
    anyEnchantment,
    socketGroup,
    alternateQuality,
  )

  protected val conditionOptions: Seq[Option[Writable with Mergeable[_]]] = operatorConditions ++ otherConditions

  val conditions: Seq[Writable with Mergeable[_]] = conditionOptions.flatten

  def operatorConditionsCanMerge(o: Condition): List[Boolean] =
    List(
      dropLevel canMerge o.dropLevel,
      gemLevel canMerge o.gemLevel,
      height canMerge o.height,
      itemLevel canMerge o.itemLevel,
      linkedSockets canMerge o.linkedSockets,
      mapTier canMerge o.mapTier,
      quality canMerge o.quality,
      sockets canMerge o.sockets,
      stackSize canMerge o.stackSize,
      width canMerge o.width,
    )

  def otherConditionsCanMerge(o: Condition): List[Boolean] =
    List(
      `class` canMerge o.`class`,
      base canMerge o.base,
      prophecy canMerge o.prophecy,
      rarity canMerge o.rarity,
      explicitMod canMerge o.explicitMod,
      shapedMap canMerge o.shapedMap,
      identified canMerge o.identified,
      corrupted canMerge o.corrupted,
      influence canMerge o.influence,
      fracturedItem canMerge o.fracturedItem,
      synthesisedItem canMerge o.synthesisedItem,
      anyEnchantment canMerge o.anyEnchantment,
      socketGroup canMerge o.socketGroup,
      alternateQuality canMerge o.alternateQuality,
    )

  def canCombine(o: Condition): Boolean =
    otherConditionsCanMerge(o).forall(identity) && operatorConditionsCanMerge(o).count(_ == false) <= 1

  private def canMergeBasesOrClasses(o: Condition): Boolean = {
    val canMergerOther: Boolean =
      prophecy == o.prophecy &&
      rarity == o.rarity &&
      explicitMod == o.explicitMod &&
      shapedMap == o.shapedMap &&
      identified == o.identified &&
      corrupted == o.corrupted &&
      influence == o.influence &&
      fracturedItem == o.fracturedItem &&
      synthesisedItem == o.synthesisedItem &&
      anyEnchantment == o.anyEnchantment &&
      socketGroup == o.socketGroup &&
      dropLevel == o.dropLevel &&
      gemLevel == o.gemLevel &&
      height == o.height &&
      itemLevel == o.itemLevel &&
      linkedSockets == o.linkedSockets &&
      mapTier == o.mapTier &&
      quality == o.quality &&
      sockets == o.sockets &&
      stackSize == o.stackSize &&
      width == o.width &&
      alternateQuality == o.alternateQuality

    val canMergeClassOrBases = this.`class` == o.`class` || (this.base.isEmpty && o.base.isEmpty)

    canMergerOther && canMergeClassOrBases
  }

  private def mergeBasesOrClasses(o: Condition): Condition =
    if (this.`class` == o.`class`) {
      this.copy(base = this.base merge o.base)
    } else {
      this.copy(`class` = this.`class` merge o.`class`)
    }

  private def canMergeOthers(o: Condition): Boolean =
    List(
      prophecy canMerge o.prophecy,
      rarity canMerge o.rarity,
      explicitMod canMerge o.explicitMod,
      shapedMap canMerge o.shapedMap,
      identified canMerge o.identified,
      corrupted canMerge o.corrupted,
      influence canMerge o.influence,
      fracturedItem canMerge o.fracturedItem,
      synthesisedItem canMerge o.synthesisedItem,
      anyEnchantment canMerge o.anyEnchantment,
      socketGroup canMerge o.socketGroup,
      dropLevel canMerge o.dropLevel,
      gemLevel canMerge o.gemLevel,
      height canMerge o.height,
      itemLevel canMerge o.itemLevel,
      linkedSockets canMerge o.linkedSockets,
      mapTier canMerge o.mapTier,
      quality canMerge o.quality,
      sockets canMerge o.sockets,
      stackSize canMerge o.stackSize,
      width canMerge o.width,
      alternateQuality canMerge o.alternateQuality,
    ).forall(identity)

  private def mergeOthers(o: Condition): Condition = {
    this.copy(
      prophecy = prophecy merge o.prophecy,
      dropLevel = dropLevel merge o.dropLevel,
      itemLevel = itemLevel merge o.itemLevel,
      quality = quality merge o.quality,
      rarity = rarity merge o.rarity,
      sockets = sockets merge o.sockets,
      linkedSockets = linkedSockets merge o.linkedSockets,
      height = height merge o.height,
      width = width merge o.width,
      gemLevel = gemLevel merge o.gemLevel,
      mapTier = mapTier merge o.mapTier,
      explicitMod = explicitMod merge o.explicitMod,
      stackSize = stackSize merge o.stackSize,
      shapedMap = shapedMap merge o.shapedMap,
      identified = identified merge o.identified,
      corrupted = corrupted merge o.corrupted,
      influence = influence merge o.influence,
      fracturedItem = fracturedItem merge o.fracturedItem,
      synthesisedItem = synthesisedItem merge o.synthesisedItem,
      anyEnchantment = anyEnchantment merge o.anyEnchantment,
      socketGroup = socketGroup merge o.socketGroup,
      alternateQuality = alternateQuality merge o.alternateQuality,
    )
  }

  override def canMerge(o: Condition): Boolean = //canMergeBasesOrClasses(o) || canMergeOthers(o)
    (otherConditionsCanMerge(o) ++ operatorConditionsCanMerge(o)).forall(identity)

  override def merge(o: Condition): Condition = {
    //mergeBasesOrClasses(o)
    Condition(
      `class` = `class` merge o.`class`,
      base = base merge o.base,
      prophecy = prophecy merge o.prophecy,
      dropLevel = dropLevel merge o.dropLevel,
      itemLevel = itemLevel merge o.itemLevel,
      quality = quality merge o.quality,
      rarity = rarity merge o.rarity,
      sockets = sockets merge o.sockets,
      linkedSockets = linkedSockets merge o.linkedSockets,
      height = height merge o.height,
      width = width merge o.width,
      gemLevel = gemLevel merge o.gemLevel,
      mapTier = mapTier merge o.mapTier,
      explicitMod = explicitMod merge o.explicitMod,
      stackSize = stackSize merge o.stackSize,
      shapedMap = shapedMap merge o.shapedMap,
      identified = identified merge o.identified,
      corrupted = corrupted merge o.corrupted,
      influence = influence merge o.influence,
      fracturedItem = fracturedItem merge o.fracturedItem,
      synthesisedItem = synthesisedItem merge o.synthesisedItem,
      anyEnchantment = anyEnchantment merge o.anyEnchantment,
      socketGroup = socketGroup merge o.socketGroup,
      alternateQuality = alternateQuality merge o.alternateQuality,
    )
  }

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
      alternateQuality = alternateQuality.orElse(o.alternateQuality),
    )
}
