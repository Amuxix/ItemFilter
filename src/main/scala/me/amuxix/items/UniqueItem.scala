package me.amuxix.items

import me.amuxix.conditions.{Condition, Unique}
import me.amuxix.providers.Provider

case class UniqueItem(name: String, baseName: String, dropEnabled: Boolean, league: Option[String]) extends Item with Area with ProviderPrice {
  override val dropLevel: Int = 1
  override def area(provider: Provider): Option[Int] = provider.bases.getByName(baseName).flatMap(_.area(provider))
  override val `class`: String = ""
  override def condition: Condition = Condition(
        base = baseName,
        rarity = Unique,
      )
}
