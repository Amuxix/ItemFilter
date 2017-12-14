package me.amuxix.categories

import me.amuxix.actions.Action
import me.amuxix.actions.Color._
import me.amuxix.actions.Sound.maps
import me.amuxix.conditions.{Condition, Unique}
import me.amuxix.{Block, FilterLevel}


object Maps extends Category {
  val redMapsMinDropLevel = 79
  val yellowMapsMinDropLevel = 74
  val whiteMapsMinDropLevel = 58

  private val mapCondition = (level: Int) => Condition(`class` = "Maps", dropLevel = (">=", level))
  private val uniqueMapCondition = (level: Int) => Condition(`class` = "Maps", dropLevel = (">=", level), rarity = Unique)

  val uniqueRed = Block(
    uniqueMapCondition(redMapsMinDropLevel),
    Action(size = 45, sound = maps.louder, borderColor = unique)
  )

  val uniqueYellow = Block(
    uniqueMapCondition(yellowMapsMinDropLevel),
    Action(size = 40, sound = maps, borderColor = unique)
  )

  val uniqueWhite = Block(
    uniqueMapCondition(whiteMapsMinDropLevel),
    Action(sound = maps.quieter, borderColor = unique)
  )

  val redMaps = Block(
    mapCondition(redMapsMinDropLevel),
    Action(size = 45, borderColor = red, sound = maps.louder)
  )

  val yellowMaps = Block(
    mapCondition(yellowMapsMinDropLevel),
    Action(size = 40, borderColor = goodYellow, sound = maps)
  )

  val whiteMaps = Block(
    mapCondition(whiteMapsMinDropLevel),
    Action(borderColor = white, sound = maps.quieter)
  )

  val t0Fragments = Block(
    Condition(base = Seq("Fragment of the Phoenix", "Fragment of the Hydra", "Mortal Ignorance", "Mortal Hope"),
    `class` = "Map Fragments"),
    Action(borderColor = darkRed, backgroundColor = white, textColor = darkRed)
  )

  val t1Fragments = Block(
    Condition(base = Seq("Yriel's Key", "Sacrifice at Midnight", "Mortal Rage", "Volkuur's Key", "Fragment of the Chimera", "Fragment of the Minotaur", "Inya's Key"),
      `class` = "Map Fragments"),
    Action(borderColor = darkRed, textColor = darkRed)
  )

  val t2Fragments = Block(
    Condition(base = Seq("Eber's Key", "Mortal Grief", "Sacrifice at Noon", "Sacrifice at Dawn", "Sacrifice at Dusk"),
      `class` = "Map Fragments"),
    Action(borderColor = black, textColor = darkRed)
  )

  val misc = Block(
    Condition(`class` = "Misc Map Items"),
    Action(backgroundColor = white, textColor = black)
  )

  val offering = Block(Condition(base = "Offering to the Goddess"))

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(uniqueRed, uniqueYellow, uniqueWhite, redMaps, yellowMaps, whiteMaps, t0Fragments, t1Fragments, t2Fragments, misc, offering)
}