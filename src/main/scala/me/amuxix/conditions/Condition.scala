package me.amuxix.conditions

import cats.Show
import me.amuxix.Mergeable
import me.amuxix.instances.option._
import me.amuxix.syntax.contravariantShow._
import me.amuxix.syntax.mergeable._

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
)

object Condition {
  implicit val show: Show[Condition] = condition => Seq(
    condition.`class`.show,
    condition.base.show,
    condition.prophecy.show,
    condition.dropLevel.show,
    condition.itemLevel.show,
    condition.quality.show,
    condition.rarity.show,
    condition.sockets.show,
    condition.linkedSockets.show,
    condition.height.show,
    condition.width.show,
    condition.gemLevel.show,
    condition.mapTier.show,
    condition.explicitMod.show,
    condition.stackSize.show,
    condition.shapedMap.show,
    condition.identified.show,
    condition.corrupted.show,
    condition.influence.show,
    condition.fracturedItem.show,
    condition.synthesisedItem.show,
    condition.anyEnchantment.show,
    condition.socketGroup.show,
    condition.alternateQuality.show,
  ).filter(_.nonEmpty).mkString("\n  ", "\n  ", "")

  implicit val mergeable: Mergeable[Condition] = new Mergeable[Condition] {
    private def operatorConditionsCanMerge(one: Condition, other: Condition): List[Boolean] =
      List(
       one.dropLevel canMerge other.dropLevel,
        one.gemLevel canMerge other.gemLevel,
        one.height canMerge other.height,
        one.itemLevel canMerge other.itemLevel,
        one.linkedSockets canMerge other.linkedSockets,
        one.mapTier canMerge other.mapTier,
        one.quality canMerge other.quality,
        one.sockets canMerge other.sockets,
        one.stackSize canMerge other.stackSize,
        one.width canMerge other.width,
      )

    private def otherConditionsCanMerge(one: Condition, other: Condition): List[Boolean] =
      List(
        one.`class` canMerge other.`class`,
        one.base canMerge other.base,
        one.prophecy canMerge other.prophecy,
        one.rarity canMerge other.rarity,
        one.explicitMod canMerge other.explicitMod,
        one.shapedMap canMerge other.shapedMap,
        one.identified canMerge other.identified,
        one.corrupted canMerge other.corrupted,
        one.influence canMerge other.influence,
        one.fracturedItem canMerge other.fracturedItem,
        one.synthesisedItem canMerge other.synthesisedItem,
        one.anyEnchantment canMerge other.anyEnchantment,
        one.socketGroup canMerge other.socketGroup,
        one.alternateQuality canMerge other.alternateQuality,
      )

    override def canMerge(one: Condition, other: Condition): Boolean = (otherConditionsCanMerge(one, other) ++ operatorConditionsCanMerge(one, other)).forall(identity)

    override def merge(one: Condition, other: Condition): Condition = Condition(
      `class` = one.`class` merge other.`class`,
      base = one.base merge other.base,
      prophecy = one.prophecy merge other.prophecy,
      dropLevel = one.dropLevel merge other.dropLevel,
      itemLevel = one.itemLevel merge other.itemLevel,
      quality = one.quality merge other.quality,
      rarity = one.rarity merge other.rarity,
      sockets = one.sockets merge other.sockets,
      linkedSockets = one.linkedSockets merge other.linkedSockets,
      height = one.height merge other.height,
      width = one.width merge other.width,
      gemLevel = one.gemLevel merge other.gemLevel,
      mapTier = one.mapTier merge other.mapTier,
      explicitMod = one.explicitMod merge other.explicitMod,
      stackSize = one.stackSize merge other.stackSize,
      shapedMap = one.shapedMap merge other.shapedMap,
      identified = one.identified merge other.identified,
      corrupted = one.corrupted merge other.corrupted,
      influence = one.influence merge other.influence,
      fracturedItem = one.fracturedItem merge other.fracturedItem,
      synthesisedItem = one.synthesisedItem merge other.synthesisedItem,
      anyEnchantment = one.anyEnchantment merge other.anyEnchantment,
      socketGroup = one.socketGroup merge other.socketGroup,
      alternateQuality = one.alternateQuality merge other.alternateQuality,
    )
  }
}
