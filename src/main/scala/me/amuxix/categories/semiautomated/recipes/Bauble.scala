package me.amuxix.categories.semiautomated.recipes
import me.amuxix.FilterRarity
import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.database.Currencies
import me.amuxix.items.GenItem

import scala.concurrent.Future

object Bauble extends SemiAutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] =
    Currencies.getByName("Glassblower's Bauble").map { glassblowersBauble =>
      def generateGenericItem(quality: Int): GenItem =
        new GenItem {
          override lazy val chaosValuePerSlot: Option[Double] = glassblowersBauble.chaosValuePerSlot.map(value => (value / 2) / (40 / quality))
          override lazy val condition: Condition = Condition(`class` = "Flask", quality = quality)
        }
      (1 to 19).map(generateGenericItem) :+
        new GenItem {
          override lazy val chaosValuePerSlot: Option[Double] = glassblowersBauble.chaosValuePerSlot.map(_ / 2)
          override lazy val condition: Condition = Condition(`class` = "Flask", quality = 20)
        }
    }

  override protected def actionForRarity: FilterRarity => Action = { _ => Action() }
}
