package me.amuxix.categories.automated

import me.amuxix.ItemFilter.ec
import me.amuxix.actions.Action
import me.amuxix.conditions.{Condition, ItemLevel}
import me.amuxix.database.Bases
import me.amuxix.items.{CategoryItem, GenItem}
import me.amuxix.{FilterRarity, Leveling}

import scala.concurrent.Future

object Flasks extends AutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = //Bases.flasks
    Bases.flasks.map(_.map { flask =>
      new CategoryItem(Leveling) {
        override def condition: Condition =
          flask.closeToZoneLevel(ItemLevel(1, flask.dropLevel + 5 max flask.dropLevel / 10), None)
      }
    })


  override protected def actionForRarity(rarity: FilterRarity): Action = Action()
}
