package me.amuxix

import me.amuxix.actions._
import me.amuxix.conditions._

trait ImplicitConversions {
  import Operator.string2Operator
  implicit def int2OptionSize(size: Int): Option[Size] = Some(Size(size))
  implicit def int2OptionSound(sound: Int): Option[Sound] = Some(Sound(sound))
  implicit def tuple22OptionSound(tuple: (Int, Int)): Option[Sound] = Some(Sound(tuple._1, tuple._2))
  implicit def color2OptionBorder(color: Color): Option[BorderColor] = Some(BorderColor(color))
  implicit def tuple32OptionBorder(color: (Int, Int, Int)): Option[BorderColor] = Some(BorderColor(color))
  implicit def color2OptionBackground(color: Color): Option[BackgroundColor] = Some(BackgroundColor(color))
  implicit def tuple32OptionBackground(color: (Int, Int, Int)): Option[BackgroundColor] = Some(BackgroundColor(color))
  implicit def color2OptionText(color: Color): Option[TextColor] = Some(TextColor(color))
  implicit def tuple32OptionText(color: (Int, Int, Int)): Option[TextColor] = Some(TextColor(color))

  implicit def string2OptionBaseType(string: String): Option[BaseType] = Some(BaseType(string))
  implicit def string2OptionBaseType2(string: Seq[String]): Option[BaseType] = Some(BaseType(string:_*))
  implicit def String2OptionItemClass(string: String): Option[ItemClass] = Some(ItemClass(string))
  implicit def String2OptionItemClass2(string: Seq[String]): Option[ItemClass] = Some(ItemClass(string:_*))
  implicit def tuple22OptionDropLevel(tuple: (Operator, Int)): Option[DropLevel] = Some(DropLevel(tuple._1, tuple._2))
  implicit def tuple22OptionDropLevel2(tuple: (String, Int)): Option[DropLevel] = Some(DropLevel(tuple._1, tuple._2))
  implicit def tuple22OptionItemLevel(tuple: (Operator, Int)): Option[ItemLevel] = Some(ItemLevel(tuple._1, tuple._2))
  implicit def tuple22OptionItemLevel2(tuple: (String, Int)): Option[ItemLevel] = Some(ItemLevel(tuple._1, tuple._2))
  implicit def tuple22OptionQuality(tuple: (Operator, Int)): Option[Quality] = Some(Quality(tuple._1, tuple._2))
  implicit def tuple22OptionQuality2(tuple: (String, Int)): Option[Quality] = Some(Quality(tuple._1, tuple._2))
  implicit def int2OptionQuality(int: Int): Option[Quality] = Some(Quality(int))
  implicit def tuple22OptionRarity(tuple: (Operator, R)): Option[Rarity] = Some(Rarity(tuple._1, tuple._2))
  implicit def tuple22OptionRarity2(tuple: (String, R)): Option[Rarity] = Some(Rarity(tuple._1, tuple._2))
  implicit def r2OptionRarity(r: R): Option[Rarity] = Some(Rarity(r))
  implicit def tuple22OptionSockets(tuple: (Operator, Int)): Option[Sockets] = Some(Sockets(tuple._1, tuple._2))
  implicit def tuple22OptionSockets2(tuple: (String, Int)): Option[Sockets] = Some(Sockets(tuple._1, tuple._2))
  implicit def int2OptionSockets(sockets: Int): Option[Sockets] = Some(Sockets(sockets))
  implicit def tuple22OptionLinkedSockets(tuple: (Operator, Int)): Option[LinkedSockets] = Some(LinkedSockets(tuple._1, tuple._2))
  implicit def tuple22OptionLinkedSockets2(tuple: (String, Int)): Option[LinkedSockets] = Some(LinkedSockets(tuple._1, tuple._2))
  implicit def int2OptionLinkedSockets(int: Int): Option[LinkedSockets] = Some(LinkedSockets(int))
  implicit def string2OptionSockets(group: String): Option[SocketGroup] = Some(SocketGroup(group))
  implicit def tuple22OptionHeight(tuple: (Operator, Int)): Option[Height] = Some(Height(tuple._1, tuple._2))
  implicit def tuple22OptionHeight2(tuple: (String, Int)): Option[Height] = Some(Height(tuple._1, tuple._2))
  implicit def int2OptionHeight(i: Int): Option[Height] = Some(Height(i))
  implicit def tuple22OptionWidth(tuple: (Operator, Int)): Option[Width] = Some(Width(tuple._1, tuple._2))
  implicit def tuple22OptionWidth2(tuple: (String, Int)): Option[Width] = Some(Width(tuple._1, tuple._2))
  implicit def int2OptionWidth(i: Int): Option[Width] = Some(Width(i))
  implicit def boolean2OptionIdentified(boolean: Boolean): Option[Identified] = Some(Identified(boolean))
  implicit def boolean2OptionCorrupted(boolean: Boolean): Option[Corrupted] = Some(Corrupted(boolean))
  implicit def boolean2OptionShapedMap(boolean: Boolean): Option[ShapedMap] = Some(ShapedMap(boolean))
  implicit def boolean2OptionShaperItem(boolean: Boolean): Option[ShaperItem] = Some(ShaperItem(boolean))
  implicit def boolean2OptionElderItem(boolean: Boolean): Option[ElderItem] = Some(ElderItem(boolean))

  implicit def color2OptionColor(color: Color): Option[Color] = Some(color)
  implicit def sound2OptionSound(sound: Sound): Option[Sound] = Some(sound)


}