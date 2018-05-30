package me.amuxix.categories

import me.amuxix._
import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.conditions.Condition

object Gems extends Category {
  val vaalGems = Block(Condition(base = "Vaal", `class`= "Gem"), Action(size = 40, textColor = Color.red, borderColor = Color.red))

  val valuable = Block(
    Condition(base = Seq("Empower", "Item Quantity", "Block Chance Reduction", "Enhance", "Added Chaos Damage", "Enlighten", "Detonate Mines", "Portal", "Vaal Breach", "Vaal Haste", "Vaal Discipline"), `class` = "Gem"),
    Action(size = 40, sound = Sound.gems, borderColor = Color.teal, backgroundColor = Color.black)
  )

  val highLevel = Block(
    Condition(`class` = "Gem", gemLevel = (">=", 18)),
    Action(size = 40, sound = Sound.gems, borderColor = Color.teal, backgroundColor = Color.darkRed)
  )

  val highQuality = Block(
    Condition(`class` = "Gem", quality = (">=", 16)),
    Action(size = 40, sound = Sound.gems, borderColor = Color.teal, backgroundColor = Color.darkRed)
  )

  val lowQuality = Block(
    Condition(`class` = "Gem", quality = (">", 0)),
    Action(size = 40, borderColor = Color.teal, backgroundColor = Color.black)
  )

  val all = Block(Condition(`class` = "Gem"), Action(borderColor = Color.teal, backgroundColor = Color.black))

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => Seq(vaalGems, valuable, highLevel, highQuality, lowQuality.hidden, all.hidden)
    case Normal => Seq(vaalGems, valuable, highLevel, highQuality, lowQuality, all.hidden)
    case Racing => Seq(vaalGems, valuable, highLevel, highQuality, lowQuality, all)
  }
}
