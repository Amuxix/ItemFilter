package me.amuxix.categories.automated

import me.amuxix.FilterRarity
import me.amuxix.actions.Action
import me.amuxix.database.Bases
import me.amuxix.items.GenItem

import scala.concurrent.Future

object Flasks extends AutomatedCategory {
  override protected val categoryItems: Future[Seq[GenItem]] = Bases.flasks
    /*flasks
      .flatten
      .sortBy(_.dropLevel)(implicitly[Ordering[Int]].reverse)
      .map(flask => new CategoryItem(Leveling) { override def condition: Condition = flask.conditionsOfBestRaresForZoneLevel }) :+
    new CategoryItem(Common) { override def condition: Condition = Condition(`class` = "Utility Flask") }*/

  override protected def actionForRarity(rarity: FilterRarity): Action = Action()
}
