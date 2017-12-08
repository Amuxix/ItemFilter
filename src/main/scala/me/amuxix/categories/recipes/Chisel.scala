package me.amuxix.categories.recipes

import me.amuxix.categories.Category
import me.amuxix.conditions.{Condition, Magic, White}
import me.amuxix.{Block, FilterLevel, Reduced}

class Chisel extends Category {
  val done = Block(Condition(base = Seq("Gavel", "Rock Breaker", "Stone Hammer"), quality = 20))
  val magic = Block(Condition(base = Seq("Gavel", "Rock Breaker", "Stone Hammer"), rarity = (">=", Magic), quality = 16))
  val white = Block(Condition(base = Seq("Gavel", "Rock Breaker", "Stone Hammer"), rarity = White, quality = 16))

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => Seq(done, magic.hidden, white.hidden)
    case _ => Seq(done, magic, white)
  }
}
