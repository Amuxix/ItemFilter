package me.amuxix.categories
import cats.data.NonEmptyList
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Action
import me.amuxix.items.{GenItem, Item}
import me.amuxix.{FilterRarity, Priced, Undetermined}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

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

  override protected val categoryItems: Future[NonEmptyList[GenItem]] = items.map(_.map {
    case item if Await.result(item.rarity, Duration.Inf) == Undetermined =>
      println(s"${item.name} has Undetermined rarity")
      item
    case item =>
      item
  })
  override protected def actionForRarity: FilterRarity => Action = {
    case priced: Priced => action(priced)
    case rarity         => throw new MatchError(s"Found $rarity but Automated Categories can only have Priced rarities")
  }
}
