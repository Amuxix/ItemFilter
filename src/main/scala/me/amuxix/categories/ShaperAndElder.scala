package me.amuxix.categories

import me.amuxix.actions.Color.shelder
import me.amuxix.actions.{Action, Color}
import me.amuxix.categories.BestBases.bestBases
import me.amuxix.conditions.{Condition, Rare}
import me.amuxix.{Block, FilterLevel, Reduced}

object ShaperAndElder extends Category {
  private val shelderAction = Action(backgroundColor = Color.shelder)

  val bestShelder: Seq[Block] = bestBases.flatMap { block =>
    Seq(
      block.copy(
        block.condition.copy(shaperItem = true),
        block.action.copy(backgroundColor = shelder)
      ),
      block.copy(
        block.condition.copy(elderItem = true),
        block.action.copy(backgroundColor = shelder)
      )
    )
  }

  val rareShaper = Block(Condition(shaperItem = true, rarity = Rare), shelderAction)
  val rareElder = Block(Condition(elderItem = true, rarity = Rare), shelderAction)
  val craftingShaper: Block = Block(Condition(shaperItem = true, rarity = ("<", Rare)), shelderAction).hidden
  val craftingElder: Block = Block(Condition(elderItem = true, rarity = ("<", Rare)), shelderAction).hidden

  override def categoryBlocks(filterLevel: FilterLevel): Seq[Block] = filterLevel match {
    case Reduced => bestShelder ++ Seq(rareShaper.hidden, rareElder.hidden, craftingShaper, craftingElder)
    case _ => bestShelder ++ Seq(rareShaper, rareElder, craftingShaper, craftingElder)
  }
}
