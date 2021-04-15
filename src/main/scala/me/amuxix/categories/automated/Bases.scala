package me.amuxix.categories.automated
import cats.data.NonEmptyList
import me.amuxix.actions.Action
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.{Item, Value}
import me.amuxix.Priced
import me.amuxix.providers.Provider

object Bases extends AutomatedCategory {

  trait BasePrice extends Value {
    override def chaosValuePerSlot(provider: Provider): Option[Double] = ???
  }

  override protected def items(provider: Provider): NonEmptyList[Item] = ???
  /*DatabaseBases.allEquipment.map { items =>
    for {
      item <- items
      iLvl <- 82 to 86
    } yield item.condition.map( itemCondition =>
      new GenericItem with Value {
        override def chaosValuePerSlot: OptionT[Future, Double] = ???
        override def condition: Future[Condition] = Future.successful(itemCondition.copy(itemLevel = (iLvl, 100)))
      }
    )
  }*/

  override protected def action: Priced => Action = ???
}
