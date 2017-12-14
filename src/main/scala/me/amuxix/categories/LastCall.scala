package me.amuxix.categories

import me.amuxix.actions.Action
import me.amuxix.actions.Color._
import me.amuxix.conditions.{Condition, Magic, Rare}
import me.amuxix.{Block, FilterLevel}

object LastCall extends Category {
  private val allWhite = Action(textColor = white, backgroundColor = white, borderColor = white)
  //val currencyAndMaps = Block(Condition(`class` = Seq("Currency", "Maps")), allWhite)
  val hidden = Action(size = 18, backgroundColor = transparent, borderColor = transparent, textColor = transparent)

  val hideBelowRare: Block = Block(
    Condition(
      `class` = Seq("Flasks", "Gloves", "Boots", "Body Armours", "Helmets", "Rings", "Belts", "Amulets", "Claws", "Daggers", "Wands", "Swords", "Bows", "Staves", "Axes", "Maces", "Quivers", "Shields", "Sceptres"),
      rarity = ("<=", Magic),
    ),
    hidden,
    show = false
  )

  val hideRemainingRares: Block = Block(
    Condition(
      `class` = Seq("Flasks", "Gloves", "Boots", "Body Armours", "Helmets", "Rings", "Belts", "Amulets", "Claws", "Daggers", "Wands", "Swords", "Bows", "Staves", "Axes", "Maces", "Quivers", "Shields", "Sceptres"),
      rarity = Rare,
    ),
    Action(),
    show = false
  )

  val showRest: Block = Block(
    Condition(),
    allWhite,
    show = true
  )

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(hideBelowRare, hideRemainingRares, showRest)
}
