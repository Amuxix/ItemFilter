package me.amuxix.actions

import me.amuxix.Writable

object Sound {
  val myths = CustomSound("Fog horn")
  val epic = CustomSound("Bell")
  val gems = CustomSound("Gem pickup")
  val betterMaps = CustomSound("Level up")
  val maps = CustomSound("AH")
  val topDivCards = CustomSound("Counter shot impact")
  val chaos = CustomSound("Chaos")
  val armourKit = CustomSound("Armour kit")
  val pileOfShit = CustomSound("What a pile of shit")
  val probablyShit = CustomSound("Probably shit")
  val portal = CustomSound("Portal")

  val nets = GameSound(2)
  val incursion = GameSound(3)
}

abstract class Sound extends Writable
