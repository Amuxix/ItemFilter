package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.Item


abstract class BasicProvider[I <: Item] {
  def all: NonEmptyList[I]

  protected def getByType[Type, ItemType](itemType: ItemType): NonEmptyList[Type] =
    all.filter(_.itemType.equalsIgnoreCase(itemType.toString)).sortBy(_.dropLevel).map(_.asInstanceOf[Type]) match {
      case Nil => throw new MatchError(s"Found 0 bases of $itemType")
      case head :: tail => NonEmptyList(head, tail)
    }

  def getByName(name: String): Option[I] =
    all.find(_.name == name)
}
