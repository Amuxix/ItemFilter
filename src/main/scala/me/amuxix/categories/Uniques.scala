package me.amuxix.categories

import me.amuxix.actions.Action
import me.amuxix.actions.Color._
import me.amuxix.actions.Sound._
import me.amuxix.conditions.{Condition, Unique}
import me.amuxix.{Block, FilterLevel}

object Uniques extends Category {
  val tabula = Block(
    Condition(base = "Simple Robe", rarity = Unique, socketGroup = "WWWWWW"),
    Action(size = 45, sound = epic, backgroundColor = unique, textColor = black)
  )

  val t0 = Block(
    Condition(
      base = Seq("Stibnite Flask", "Ruby Flask", "Topaz Flask", "Sapphire Flask", "Silver Flask", "Void Axe", "Prophecy Wand", "Jewelled Foil", "Sorcerer Boots", "Occultist's Vestment", "Crusader Boots", "Clasped Mitts", "Rawhide Boots", "Ezomyte Tower Shield", "Deicide Mask", "Glorious Plate", "Cutlass", "Ezomyte Burgonet", "Assassin's Garb", "Royal Axe", "Crystal Belt"),
      rarity = Unique,
    ),
    Action(
      size = 45,
      sound = myths,
      backgroundColor = white,
      textColor = unique,
      borderColor = unique,
    )
  )

  val t1 = Block(
    Condition(
      base = Seq("Blinder", "Granite Flask", "Grand Mana Flask", "Jasper Chopper", "Fiend Dagger", "Jingling Spirit Shield", "Imperial Staff", "Carnal Sceptre", "Labrys", "Siege Axe", "Abyssal Axe", "Savant's Robe", "Penetrating Arrow Quiver", "Cedar Tower Shield", "Gladiator Plate", "Vaal Regalia", "Sacrificial Garb", "Archon Kite Shield", "Onyx Amulet", "Two-Stone Ring", "Gold Ring", "Goathide Boots", "Ebony Tower Shield", "Blinder", "Ritual Sceptre", "Judgement Staff", "Vaal Sceptre", "Legion Gloves", "Raven Mask", "Champion Kite Shield", "Ironscale Gauntlets", "Murder Boots", "Ancient Greaves", "Sharkskin Tunic", "Elegant Ringmail", "Saintly Chainmail", "Tiger Sword"),
      rarity = Unique,
    ),
    Action(
      size = 45,
      sound = epic,
      backgroundColor = unique,
      textColor = black,
    )
  )

  val rest = Block(Condition(rarity = Unique), Action(borderColor = unique))

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(tabula, t0, t1, rest)
}
