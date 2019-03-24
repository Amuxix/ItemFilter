package me.amuxix.categories
import cats.data.NonEmptyList
import me.amuxix.{FilterRarity, Mythic, Priced, Undetermined}
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Action
import me.amuxix.items.{GenericItem, Item}

import scala.concurrent.Future

trait AutomatedCategory extends SemiAutomatedCategory {
  protected def items: Future[NonEmptyList[Item]]
  protected def action: Priced => Action
  /*
  rarity match {
    case Common =>
    case Uncommon =>
    case Rare =>
    case Epic =>
    case Mythic =>
  }
   */

  override protected val categoryItems: Future[NonEmptyList[GenericItem]] = items.map(items => NonEmptyList.fromListUnsafe(items.filter(_.dropEnabled)))
  override protected def actionForRarity: FilterRarity => Action = {
    case priced: Priced => action(priced)
    case `Undetermined` =>
      println("Assuming mythic rarity for item without price.")
      action(Mythic)
    case rarity         => throw new MatchError(s"Found $rarity but Automated Categories can only have Priced rarities")
  }
}
