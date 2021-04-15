package me.amuxix.categories.semiautomated.recipes

import cats.data.NonEmptyList
import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.{GenericItem, Value}
import me.amuxix.providers.Provider

object Bauble extends SemiAutomatedCategory {

  override protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = NonEmptyList.fromListUnsafe(provider.currencies.getByName("Glassblower's Bauble").map { glassblowersBauble =>
    def generateGenericItem(quality: Int): GenericItem = new GenericItem with Value {
      override def chaosValuePerSlot(provider: Provider): Option[Double] = glassblowersBauble.chaosValuePerSlot(provider).map(value => (value / 2) / (40 / quality))
      override lazy val condition: Condition = Condition(`class` = "Flask", quality = quality)
    }
    (1 to 19).map(generateGenericItem) :+ new GenericItem with Value {
      override def chaosValuePerSlot(provider: Provider): Option[Double] = glassblowersBauble.chaosValuePerSlot(provider).map(_ / 2)
      override lazy val condition: Condition = Condition(`class` = "Flask", quality = 20)
    }
  }.toList.flatten)

  override protected def actionForRarity: FilterRarity => Action = _ => Action()
}
