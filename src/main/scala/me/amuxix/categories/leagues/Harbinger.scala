package me.amuxix.categories.leagues

import me.amuxix.actions.{Action, Color, Sound}
import me.amuxix.categories.Category
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel, Reduced}

object Harbinger extends Category {
  val t0 = Block(Condition(base = "Mirror Shard", `class` = "Currency"), Action(size = 45, sound = Sound.myths, borderColor = Color.black, textColor = Color.black, backgroundColor = Color.lightGreen))
  val t1 = Block(
    Condition(base = Seq("Orb of Annulment", "Orb of Binding", "Orb of Horizons", "Harbinger's Orb", "Engineer's Orb", "Ancient Orb", "Exalted Shard"), `class` = "Currency"),
    Action(size = 45, sound = Sound.rare, borderColor = Color.black, textColor = Color.black, backgroundColor = Color.goodYellow.lighten)
  )
  val t2 = Block(
    Condition(base = Seq("Annulment Shard", "Binding Shard", "Horizon Shard", "Harbinger's Shard", "Engineer's Shard", "Ancient Shard"), `class` = "Currency"),
    Action(size = 45, sound = Sound.t2Currency, borderColor = Color.goodYellow, textColor = Color.goodYellow)
  )
  val t3 = Block(
    Condition(base = Seq("Chaos Shard", "Regal Shard"), `class` = "Currency"),
    Action(size = 45, sound = Sound.t3Currency, borderColor = Color.goodYellow, textColor = Color.goodYellow)
  )
  val pieces = Block(
    Condition(`class`= "Piece"),
    Action(size = 45, sound = Sound.pieces, borderColor = Color.blue, textColor = Color.blue)
  )

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => Seq(t0, t1, t2, t3, pieces.hidden)
    case _ => Seq(t0, t1, t2, t3, pieces)
  }
}
