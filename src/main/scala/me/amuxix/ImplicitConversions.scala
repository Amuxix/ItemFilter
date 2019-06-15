package me.amuxix

import me.amuxix.actions._
import me.amuxix.conditions._

trait ImplicitConversions {
  implicit def int2OptionSize(size: Int): Option[Size] = Some(Size(size))
  implicit def int2OptionGameSound(sound: Int): Option[Sound] =
    Some(GameSound(sound))
  implicit def tuple22OptionGameSound(tuple: (Int, Int)): Option[Sound] =
    Some(GameSound(tuple._1, tuple._2))
  implicit def color2OptionBorder(color: Color): Option[BorderColor] =
    Some(BorderColor(color))
  implicit def tuple32OptionBorder(color: (Int, Int, Int)): Option[BorderColor] = Some(BorderColor(color))
  implicit def color2OptionBackground(color: Color): Option[BackgroundColor] =
    Some(BackgroundColor(color))
  implicit def tuple32OptionBackground(color: (Int, Int, Int)): Option[BackgroundColor] =
    Some(BackgroundColor(color))
  implicit def color2OptionText(color: Color): Option[TextColor] =
    Some(TextColor(color))
  implicit def tuple32OptionText(color: (Int, Int, Int)): Option[TextColor] =
    Some(TextColor(color))
  implicit def tuple22OptionMinimapIcon(tuple: (EffectColor, Shape)): Option[MinimapIcon] =
    Some(MinimapIcon(tuple._1, tuple._2))
  implicit def tuple32OptionMinimapIcon(tuple: (EffectColor, Shape, IconSize)): Option[MinimapIcon] =
    Some(MinimapIcon(tuple._1, tuple._2, tuple._3))
  implicit def effectColor2OptionBeam(color: EffectColor): Option[Beam] =
    Some(Beam(color))
  implicit def tuple22OptionBeam(tuple: (EffectColor, Boolean)): Option[Beam] =
    Some(Beam(tuple._1, tuple._2))

  implicit def string2OptionBaseType(string: String): Option[BaseType] =
    Some(BaseType(string))
  implicit def string2OptionBaseType2(string: Seq[String]): Option[BaseType] =
    Some(BaseType(string: _*))
  implicit def string2OptionProphecy(string: String): Option[Prophecy] =
    Some(Prophecy(string))
  implicit def string2OptionProphecy2(string: Seq[String]): Option[Prophecy] =
    Some(Prophecy(string: _*))
  implicit def String2OptionItemClass(string: String): Option[ItemClass] =
    Some(ItemClass(string))
  implicit def String2OptionItemClass2(string: Seq[String]): Option[ItemClass] =
    Some(ItemClass(string: _*))
  implicit def tuple22OptionDropLevel(tuple: (Int, Int)): Option[DropLevel] =
    Some(DropLevel(tuple._1, tuple._2))
  implicit def int2OptionDropLevel(int: Int): Option[DropLevel] =
    Some(DropLevel(int))
  implicit def tuple22OptionItemLevel(tuple: (Int, Int)): Option[ItemLevel] =
    Some(ItemLevel(tuple._1, tuple._2))
  implicit def int2OptionItemLevel(int: Int): Option[ItemLevel] =
    Some(ItemLevel(int))
  implicit def tuple22OptionQuality2(tuple: (Int, Int)): Option[Quality] =
    Some(Quality(tuple._1, tuple._2))
  implicit def int2OptionQuality(int: Int): Option[Quality] = Some(Quality(int))
  implicit def tuple22OptionRarity(tuple: (GameRarity, GameRarity)): Option[Rarity] =
    Some(Rarity(tuple._1, tuple._2))
  implicit def r2OptionRarity(r: GameRarity): Option[Rarity] = Some(Rarity(r))
  implicit def tuple22OptionSockets(tuple: (Int, Int)): Option[Sockets] =
    Some(Sockets(tuple._1, tuple._2))
  implicit def int2OptionSockets(sockets: Int): Option[Sockets] =
    Some(Sockets(sockets))
  implicit def tuple22OptionLinkedSockets(tuple: (Int, Int)): Option[LinkedSockets] =
    Some(LinkedSockets(tuple._1, tuple._2))
  implicit def int2OptionLinkedSockets(int: Int): Option[LinkedSockets] =
    Some(LinkedSockets(int))
  implicit def string2OptionSockets(group: String): Option[SocketGroup] =
    Some(SocketGroup(group))
  implicit def tuple22OptionHeight(tuple: (Int, Int)): Option[Height] =
    Some(Height(tuple._1, tuple._2))
  implicit def int2OptionHeight(i: Int): Option[Height] = Some(Height(i))
  implicit def tuple22OptionWidth(tuple: (Int, Int)): Option[Width] =
    Some(Width(tuple._1, tuple._2))
  implicit def int2OptionWidth(i: Int): Option[Width] = Some(Width(i))
  implicit def boolean2OptionIdentified(boolean: Boolean): Option[Identified] =
    Some(Identified(boolean))
  implicit def boolean2OptionCorrupted(boolean: Boolean): Option[Corrupted] =
    Some(Corrupted(boolean))
  implicit def boolean2OptionShapedMap(boolean: Boolean): Option[ShapedMap] =
    Some(ShapedMap(boolean))
  implicit def boolean2OptionShaperItem(boolean: Boolean): Option[ShaperItem] =
    Some(ShaperItem(boolean))
  implicit def boolean2OptionElderItem(boolean: Boolean): Option[ElderItem] =
    Some(ElderItem(boolean))
  implicit def boolean2OptionFracturedItem(boolean: Boolean): Option[FracturedItem] = Some(FracturedItem(boolean))
  implicit def boolean2OptionSynthesisedItem(boolean: Boolean): Option[SynthesisedItem] =
    Some(SynthesisedItem(boolean))
  implicit def boolean2OptionAnyEnchantment(boolean: Boolean): Option[AnyEnchantment] = Some(AnyEnchantment(boolean))
  implicit def tuple22OptionGemLevel(tuple: (Int, Int)): Option[GemLevel] =
    Some(GemLevel(tuple._1, tuple._2))
  implicit def int2OptionGemLevel(int: Int): Option[GemLevel] =
    Some(GemLevel(int))
  implicit def tuple22OptionMapTier(tuple: (Int, Int)): Option[MapTier] =
    Some(MapTier(tuple._1, tuple._2))
  implicit def int2OptionMapTier(int: Int): Option[MapTier] = Some(MapTier(int))
  implicit def string2OptionExplicitMod(string: String): Option[ExplicitMod] =
    Some(ExplicitMod(string))
  implicit def string2OptionExplicitMod2(string: Seq[String]): Option[ExplicitMod] = Some(ExplicitMod(string: _*))

  implicit def color2OptionColor(color: Color): Option[Color] = Some(color)
  implicit def sound2OptionSound(sound: Sound): Option[Sound] = Some(sound)
  implicit def gameSound2OptionGameSound(sound: GameSound): Option[GameSound] =
    Some(sound)
  implicit def customSound2OptionCustomSound(sound: CustomSound): Option[CustomSound] = Some(sound)
}
