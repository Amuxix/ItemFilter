package me.amuxix.categories

import me.amuxix._
import me.amuxix.actions.Color._
import me.amuxix.actions.Sound._
import me.amuxix.actions.{Sound, _}
import me.amuxix.conditions.Condition

object Currency extends Category {

  val t0MissingSound: Sound => Action = (sound: Sound) =>
    Action(
      size = 45,
      sound = sound,
      backgroundColor = lightGreen,
      textColor = black,
      borderColor = black,
      minimapIcon = (Green, Star),
      beam = Green,
  )
  val t1MissingSound: Sound => Action = (sound: Sound) =>
    Action(
      size = 45,
      sound = sound,
      backgroundColor = black,
      textColor = goodYellow,
      borderColor = goodYellow,
      minimapIcon = (Yellow, Star),
      beam = Yellow,
  )

  val eternal = Block(Condition(base = "Eternal Orb", `class` = "Currency"), t0MissingSound(myths))
  val mirror = Block(Condition(base = "Mirror of Kalandra", `class` = "Currency"), t0MissingSound(myths))
  val exalt = Block(Condition(base = "Exalted Orb", `class` = "Currency"), t0MissingSound(myths))
  val divine = Block(Condition(base = "Divine Orb", `class` = "Currency"), t0MissingSound(myths))
  val masterSextant = Block(Condition(base = "Master Cartographer's Sextant", `class` = "Currency"), t0MissingSound(epic))
  val t0: Seq[Block] = Seq(eternal, mirror, exalt, divine, masterSextant)

  val chaos = Block(Condition(base = "Chaos Orb", `class` = "Currency"), t1MissingSound(Sound.chaos))
  val regal = Block(Condition(base = "Regal Orb", `class` = "Currency"), t1MissingSound(Sound.chaos))
  val vaal = Block(Condition(base = "Vaal Orb", `class` = "Currency"), t1MissingSound(Sound.chaos))
  val fusing = Block(Condition(base = "Orb of Fusing", `class` = "Currency"), t1MissingSound(Sound.chaos))

  val remainingT1 = Block(
    Condition(base = Seq("Silver Coin", "Orb of Regret", "Gemcutter's Prism", "Cartographer's Sextant", "Divine Vessel", "Stacked Deck"), `class` = "Currency"),
    t1MissingSound(rare)
  )
  val t1: Seq[Block] = Seq(chaos, regal, vaal, fusing, remainingT1)

  val t2 = Block(
    Condition(
      base = Seq("Blessed Orb", "Cartographer's Chisel", "Glassblower's Bauble", "Orb of Alchemy", "Orb of Chance", "Orb of Scouring", "Jeweller's Orb", "Perandus Coin"),
      `class` = "Currency",
    ),
    Action(
      size = 45,
      sound = rare,
      backgroundColor = black,
      textColor = goodYellow.lighten,
      borderColor = goodYellow.lighten,
      minimapIcon = (Yellow, Hexagon),
      beam = (Yellow, true),
    )
  )

  val t3 = Block(
    Condition(
      base = Seq("Armourer's Scrap", "Blacksmith's Whetstone", "Chromatic Orb", "Orb of Alteration", "Orb of Augmentation", "Orb of Transmutation"),
      `class` = "Currency",
    ),
    Action(
      size = 45,
      backgroundColor = black,
      textColor = goodYellow.lighten,
      borderColor = goodYellow.lighten,
      beam = (Yellow, true),
    )
  )

  val portal = Block(
    Condition(
      base = "Portal Scroll",
      `class` = "Currency",
    ),
    Action(size = 40, backgroundColor = black, textColor = goodYellow.lighten, sound = scrolls)
  )

  val wisdom = Block(
    Condition(
      base = "Scroll of Wisdom",
      `class` = "Currency",
    ),
    Action(size = 40, backgroundColor = black, textColor = goodYellow.lighten)
  )

  val shards = Block(
    Condition(
      base = Seq("Alchemy Shard", "Alteration Shard", "Scroll Fragment", "Transmutation Shard"),
      `class` = "Currency",
    ),
    Action(size = 40, backgroundColor = black, textColor = goodYellow.lighten)
  )

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => t0 ++ t1 ++ Seq(t2, t3.hidden, portal.hidden, wisdom.hidden, shards.hidden)
    case Normal  => t0 ++ t1 ++ Seq(t2, t3, portal, wisdom.hidden, shards.hidden)
    case Racing  => t0 ++ t1 ++ Seq(t2, t3, portal, wisdom, shards)
  }
}
