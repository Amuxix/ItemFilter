package me.amuxix.categories

import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

class Gems extends Category {
  val vaalGems = Block(Condition(base = "Vaal", `class`= "Gem"), Action(size = 40, text = Color.red, border = Color.red))

  val valuable = Block(
    Condition(base = Seq("Empower", "Item Quantity", "Block Chance Reduction", "Enhance", "Added Chaos Damage", "Enlighten", "Detonate Mines", "Portal", "Vaal Breach", "Vaal Haste", "Vaal Discipline")),
    Action(size = 40, sound = Sound.gems, border = Color.teal, background = Color.black)
  )


  val highQuality = Block(
    Condition(`class` = "Gem", quality = (">=", 16)),
    Action(size = 40, sound = Sound.gems, border = Color.teal, background = Color.darkRed)
  )

  val lowQuality = Block(
    Condition(`class` = "Gem", quality = (">=", 0)),
    Action(size = 40, border = Color.teal, background = Color.black)
  )

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(vaalGems, valuable, highQuality, lowQuality)
}
