package me.amuxix.actions

import me.amuxix.Writable

object Sound {
  val myths = CustomSound("Myths")
  val epic = CustomSound("Epic")
  val rare = CustomSound("Rare")
  val sixLinks = CustomSound("Six Links")
  val gems = CustomSound("Gems")
  val t2Currency = CustomSound("t2Currency")
  val t3Currency = CustomSound("t3Currency")
  val pieces = CustomSound("Pieces")
  val redMaps = CustomSound("Red Maps")
  val yellowMaps = CustomSound("Yellow Maps")
  val whiteMaps = CustomSound("White Maps")
  val divCards = CustomSound("Div Cards")
  val topDivCards = CustomSound("Top Div Cards")
  val scrolls = CustomSound("Scrolls")
  val chaos = CustomSound("Chaos")

  val nets = GameSound(2)
  val incursion = GameSound(3)
}

abstract class Sound extends Writable
