package me.amuxix.categories

import me.amuxix._
import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.conditions.Condition

class Currency extends Category {
  val t0MissingSound: Sound => Action = (sound: Sound) => Action(size = 45, sound = sound, background = Color.lightGreen, text = Color.black, border = Color.black)
  val t1MissingSound: Sound => Action = (sound: Sound) => Action(size = 45, sound = sound, background = Color.black, text = Color.goodYellow, border = Color.goodYellow)

  val eternal = Block(Condition(base = "Eternal Orb", `class` = "Currency"), t0MissingSound(Sound.myths))
  val mirror = Block(Condition(base = "Mirror of Kalandra", `class` = "Currency"), t0MissingSound(Sound.myths))
  val exalt = Block(Condition(base = "Exalted Orb", `class` = "Currency"), t0MissingSound(Sound.myths))
  val divine = Block(Condition(base = "Divine Orb", `class` = "Currency"), t0MissingSound(Sound.myths))
  val masterSextant = Block(Condition(base = "Master Cartographer's Sextant", `class` = "Currency"), t0MissingSound(Sound.epic))
  val t0: Seq[Block] = Seq(eternal, mirror, exalt, divine, masterSextant)

  val chaos = Block(Condition(base = "Chaos Orb", `class` = "Currency"), t0MissingSound(Sound.rare))
  val regal = Block(Condition(base = "Regal Orb", `class` = "Currency"), t0MissingSound(Sound.rare))
  val vaal = Block(Condition(base = "Vaal Orb", `class` = "Currency"), t0MissingSound(Sound.rare))
  val fusing = Block(Condition(base = "Orb of Fusing", `class` = "Currency"), t0MissingSound(Sound.rare))
  val remainingT1 = Block(Condition(base = Seq("Silver Coin", "Orb of Regret", "Gemcutter's Prism", "Cartographer's Sextant", "Divine Vessel"), `class` = "Currency"), t0MissingSound(Sound.rare.quieter))
  val t1: Seq[Block] = Seq(chaos, regal, vaal, fusing, remainingT1)

  val t2 = Block(
    Condition(
      base = Seq("Blessed Orb", "Cartographer's Chisel", "Glassblower's Bauble", "Orb of Alchemy", "Orb of Chance", "Orb of Scouring", "Jeweller's Orb", "Perandus Coin"),
      `class` = "Currency",
    ),
    Action(size = 45, sound = Sound.rare.quieter, background = Color.black, text = Color.lightYellow, border = Color.lightYellow)
  )

  val t3 = Block(
    Condition(
      base = Seq("Armourer's Scrap", "Blacksmith's Whetstone", "Chromatic Orb", "Orb of Alteration", "Orb of Augmentation", "Orb of Transmutation"),
      `class` = "Currency",
    ),
    Action(size = 45, background = Color.black, text = Color.lightYellow, border = Color.lightYellow)
  )

  val t4 = Block(
    Condition(
      base = Seq("Portal Scroll", "Scroll of Wisdom", "Alchemy Shard", "Alteration Shard", "Scroll Fragment", "Transmutation Shard"),
      `class` = "Currency",
    ),
    Action(size = 40, background = Color.black, text = Color.lightYellow)
  )

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => t0 ++ t1 ++ Seq(t2, t3.hidden, t4.hidden)
    case Normal => t0 ++ t1 ++ Seq(t2, t3, t4.hidden)
    case Leveling => t0 ++ t1 ++ Seq(t2, t3, t4)
  }
}
