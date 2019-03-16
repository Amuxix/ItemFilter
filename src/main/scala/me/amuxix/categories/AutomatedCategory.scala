package me.amuxix.categories
import me.amuxix.actions.Action
import me.amuxix.items.{GenItem, Item}
import me.amuxix.{FilterRarity, Priced}

import scala.concurrent.Future

trait AutomatedCategory extends SemiAutomatedCategory {
  protected val items: Future[Seq[Item]]
  protected def action: FilterRarity with Priced => Action
  /*
  rarity match {
    case Common =>
    case Uncommon =>
    case Rare =>
    case Epic =>
    case Mythic =>
  }
  */

  override protected val categoryItems: Future[Seq[GenItem]] = items
  override protected def actionForRarity: FilterRarity => Action = {
    case priced: Priced =>  action(priced)
    case _ => throw new MatchError("Automated categories can only have Priced rarities")
  }
}
