package me.amuxix

import me.amuxix.actions._
import me.amuxix.conditions._

trait Default[T] {
  /***
    * This specifies a default value of the T type, it doesn't really matter what it's value is as
    * will only compared by reference
    */
  val default: T
}

object Default {
  def getDefault(thing: Writable): Writable = thing match {
    case _: Background => Background.default
    case _: Border => Border.default
    case _: Size => Size.default
    case _: Sound => Sound.default
    case _: Text => Text.default
    case _: BaseType => BaseType.default
    case _: DropLevel => DropLevel.default
    case _: Height => Height.default
    case _: ItemClass => ItemClass.default
    case _: ItemLevel => ItemLevel.default
    case _: LinkedSockets => LinkedSockets.default
    case _: Quality => Quality.default
    case _: Rarity => Rarity.default
    case _: SocketGroup => SocketGroup.default
    case _: Sockets => Sockets.default
    case _: Width => Width.default
  }
}