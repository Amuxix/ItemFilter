package me.amuxix.categories

import me.amuxix.actions.Action
import me.amuxix.actions.Color._
import me.amuxix.conditions.{Condition, Magic, White}
import me.amuxix.{Block, FilterLevel}

object LastCall extends Category {
  val currencyAndMaps = Block(Condition(`class` = Seq("Currency", "Maps")), Action(text = white, background = white, border = white))
  val hidden = Action(size = 18, background = transparent, border = transparent)
  val hideWhites: Block = Block(
    Condition(
      `class` = Seq("Flasks", "Gloves", "Boots", "Body Armours", "Helmets", "Rings", "Belts", "Amulets", "Claws", "Daggers", "Wands", "Swords", "Bows", "Staves", "Axes", "Maces", "Quivers", "Shields", "Sceptres"),
      rarity = White,
    ),
    hidden,
    show = false
  )

  val hideMagic: Block = Block(
    Condition(
      `class` = Seq("Flasks", "Gloves", "Boots", "Body Armours", "Helmets", "Rings", "Belts", "Amulets", "Claws", "Daggers", "Wands", "Swords", "Bows", "Staves", "Axes", "Maces", "Quivers", "Shields", "Sceptres"),
      rarity = Magic,
    ),
    hidden,
    show = false
  )

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(currencyAndMaps, hideWhites, hideMagic)
}