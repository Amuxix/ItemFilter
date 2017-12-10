package me.amuxix.categories.leagues

import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

object Essence extends Category {
  val top = Block(
    Condition(base = Seq("Deafening Essence", "Essence of Hysteria", "Essence of Insanity", "Essence of Horror", "Essence of Delirium"), `class` = "Currency"),
    Action(size = 45, borderColor = Color.black, backgroundColor = Color.slimeGreen, textColor = Color.black)
  )

  val valueable = Block(
    Condition(base = Seq("Shrieking Essence", "Remnant of Corruption", "Screaming Essence"), `class` = "Currency"),
    Action(size = 40, borderColor = Color.black, backgroundColor = Color.slimeGreen.darken, textColor = Color.black)
  )

  val base = Block(
    Condition(base = "Essence", `class` = "Currency"),
    Action(textColor = Color.slimeGreen)
  )

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(top, valueable, base)
}
