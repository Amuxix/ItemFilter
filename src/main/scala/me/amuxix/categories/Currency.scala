package me.amuxix.categories

import me.amuxix._
import me.amuxix.actions.{Action, Color, GameSound, Sound}
import me.amuxix.conditions.Condition

object Currency extends Category {

  val t0MissingSound: Sound => Action = (sound: Sound) =>
    Action(
      size = 45,
      sound = sound,
      backgroundColor = Color.lightGreen,
      textColor = Color.black,
      borderColor = Color.black
  )
  val t1MissingSound: Sound => Action = (sound: Sound) => Action(size = 45, sound = sound, backgroundColor = Color.black, textColor = Color.goodYellow, borderColor = Color.goodYellow)

  val eternal = Block(Condition(base = "Eternal Orb", `class` = "Currency"), t0MissingSound(GameSound.myths))
  val mirror = Block(Condition(base = "Mirror of Kalandra", `class` = "Currency"), t0MissingSound(GameSound.myths))
  val exalt = Block(Condition(base = "Exalted Orb", `class` = "Currency"), t0MissingSound(GameSound.myths))
  val divine = Block(Condition(base = "Divine Orb", `class` = "Currency"), t0MissingSound(GameSound.myths))
  val masterSextant = Block(Condition(base = "Master Cartographer's Sextant", `class` = "Currency"), t0MissingSound(GameSound.epic))
  val t0: Seq[Block] = Seq(eternal, mirror, exalt, divine, masterSextant)

  val chaos = Block(Condition(base = "Chaos Orb", `class` = "Currency"), t1MissingSound(GameSound.rare))
  val regal = Block(Condition(base = "Regal Orb", `class` = "Currency"), t1MissingSound(GameSound.rare))
  val vaal = Block(Condition(base = "Vaal Orb", `class` = "Currency"), t1MissingSound(GameSound.rare))
  val fusing = Block(Condition(base = "Orb of Fusing", `class` = "Currency"), t1MissingSound(GameSound.rare))

  val remainingT1 = Block(
    Condition(base = Seq("Silver Coin", "Orb of Regret", "Gemcutter's Prism", "Cartographer's Sextant", "Divine Vessel", "Stacked Deck"), `class` = "Currency"),
    t1MissingSound(GameSound.rare.quieter)
  )
  val t1: Seq[Block] = Seq(chaos, regal, vaal, fusing, remainingT1)

  val t2 = Block(
    Condition(
      base = Seq("Blessed Orb", "Cartographer's Chisel", "Glassblower's Bauble", "Orb of Alchemy", "Orb of Chance", "Orb of Scouring", "Jeweller's Orb", "Perandus Coin"),
      `class` = "Currency",
    ),
    Action(size = 45, sound = GameSound.rare.quieter, backgroundColor = Color.black, textColor = Color.goodYellow.lighten, borderColor = Color.goodYellow.lighten)
  )

  val t3 = Block(
    Condition(
      base = Seq("Armourer's Scrap", "Blacksmith's Whetstone", "Chromatic Orb", "Orb of Alteration", "Orb of Augmentation", "Orb of Transmutation"),
      `class` = "Currency",
    ),
    Action(size = 45, backgroundColor = Color.black, textColor = Color.goodYellow.lighten, borderColor = Color.goodYellow.lighten)
  )

  val portal = Block(
    Condition(
      base = "Portal Scroll",
      `class` = "Currency",
    ),
    Action(size = 40, backgroundColor = Color.black, textColor = Color.goodYellow.lighten)
  )

  val wisdom = Block(
    Condition(
      base = "Scroll of Wisdom",
      `class` = "Currency",
    ),
    Action(size = 40, backgroundColor = Color.black, textColor = Color.goodYellow.lighten)
  )

  val shards = Block(
    Condition(
      base = Seq("Alchemy Shard", "Alteration Shard", "Scroll Fragment", "Transmutation Shard"),
      `class` = "Currency",
    ),
    Action(size = 40, backgroundColor = Color.black, textColor = Color.goodYellow.lighten)
  )

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => t0 ++ t1 ++ Seq(t2, t3.hidden, portal.hidden, wisdom.hidden, shards.hidden)
    case Normal  => t0 ++ t1 ++ Seq(t2, t3, portal, wisdom.hidden, shards.hidden)
    case Racing  => t0 ++ t1 ++ Seq(t2, t3, portal, wisdom, shards)
  }
}
