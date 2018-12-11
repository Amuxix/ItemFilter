package me.amuxix.categories.automated

import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.bases.Base.flasks
import me.amuxix.items.{CategoryItem, GenItem}
import me.amuxix.{Common, FilterRarity, Leveling}

object Flasks extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] =
    flasks
      .flatten
      .sortBy(_.dropLevel)(implicitly[Ordering[Int]].reverse)
      .map(flask => new CategoryItem(Leveling) { override protected def condition: Condition = flask.conditionsOfBestRaresForZoneLevel }) :+
    new CategoryItem(Common) { override protected def condition: Condition = Condition(`class` = "Utility Flask") }

  override protected def actionForRarity(rarity: FilterRarity): Action = Action()
}
