package me.amuxix.categories.leagues

import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

object Essence extends Category {
  val top = Block(
    Condition(base = Seq("Deafening Essence", "Essence of Hysteria", "Essence of Insanity", "Essence of Horror", "Essence of Delirium"), `class` = "Currency"),
    Action(size = 45, border = Color.black, background = Color.slimeGreen, text = Color.black)
  )

  val valueable = Block(
    Condition(base = Seq("Shrieking Essence", "Remnant of Corruption", "Screaming Essence"), `class` = "Currency"),
    Action(size = 40, border = Color.black, background = Color.slimeGreen.darken, text = Color.black)
  )

  val base = Block(
    Condition(base = "Essnece", `class` = "Currency"),
    Action(text = Color.slimeGreen)
  )

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(top, valueable, base)
}
