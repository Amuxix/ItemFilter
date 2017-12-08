package me.amuxix.categories

import me.amuxix.actions.Action
import me.amuxix.actions.Color._
import me.amuxix.actions.Sound.maps
import me.amuxix.categories.Maps._
import me.amuxix.conditions.{Condition, Unique}
import me.amuxix.{Block, FilterLevel}


object Maps {
  val redMapsMinDropLevel = 79
  val yellowMapsMinDropLevel = 74
  val whiteMapsMinDropLevel = 58
}

class Maps extends Category {
  private val mapCondition = (level: Int) => Condition(`class` = "Maps", dropLevel = (">=", level))
  private val uniqueMapCondition = (level: Int) => Condition(`class` = "Maps", dropLevel = (">=", level), rarity = Unique)

  val uniqueRed = Block(
    uniqueMapCondition(redMapsMinDropLevel),
    Action(size = 45, sound = maps.louder, border = unique)
  )

  val uniqueYellow = Block(
    uniqueMapCondition(yellowMapsMinDropLevel),
    Action(size = 40, sound = maps, border = unique)
  )

  val uniqueWhite = Block(
    uniqueMapCondition(whiteMapsMinDropLevel),
    Action(sound = maps.quieter, border = unique)
  )

  val redMaps = Block(
    mapCondition(redMapsMinDropLevel),
    Action(size = 45, border = red, sound = maps.louder)
  )

  val yellowMaps = Block(
    mapCondition(redMapsMinDropLevel),
    Action(size = 40, border = goodYellow, sound = maps)
  )

  val whiteMaps = Block(
    mapCondition(redMapsMinDropLevel),
    Action(border = white, sound = maps.quieter)
  )

  val t0Fragments = Block(
    Condition(base = Seq("Fragment of the Phoenix", "Fragment of the Hydra", "Mortal Ignorance", "Mortal Hope"),
    `class` = "Map Fragments"),
    Action(border = darkRed, background = white, text = darkRed)
  )

  val t1Fragments = Block(
    Condition(base = Seq("Yriel's Key", "Sacrifice at Midnight", "Mortal Rage", "Volkuur's Key", "Fragment of the Chimera", "Fragment of the Minotaur", "Inya's Key"),
      `class` = "Map Fragments"),
    Action(border = darkRed, text = darkRed)
  )

  val t2Fragments = Block(
    Condition(base = Seq("Eber's Key", "Mortal Grief", "Sacrifice at Noon", "Sacrifice at Dawn", "Sacrifice at Dusk"),
      `class` = "Map Fragments"),
    Action(border = black, text = darkRed)
  )

  val misc = Block(
    Condition(`class` = "Misc Map Items"),
    Action(background = white, text = black)
  )

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(uniqueRed, uniqueYellow, uniqueWhite, redMaps, yellowMaps, whiteMaps, t0Fragments, t1Fragments, t2Fragments, misc)
}