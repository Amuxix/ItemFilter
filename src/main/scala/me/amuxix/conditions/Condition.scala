package me.amuxix.conditions

import me.amuxix.Writable

case class Condition(base: BaseType = BaseType.default,
                     clazz: ItemClass = ItemClass.default,
                     dropLevel: DropLevel = DropLevel.default,
                     itemLevel: ItemLevel = ItemLevel.default,
                     quality: Quality = Quality.default,
                     rarity: Rarity = Rarity.default,
                     sockets: Sockets = Sockets.default,
                     linkedSockets: LinkedSockets = LinkedSockets.default,
                     socketGroup: SocketGroup = SocketGroup.default,
                     height: Height = Height.default,
                     width: Width = Width.default) {
  val conditions: Seq[Writable] = Seq(base, clazz, dropLevel, itemLevel, quality, rarity, sockets, linkedSockets, socketGroup, height, width)

}
