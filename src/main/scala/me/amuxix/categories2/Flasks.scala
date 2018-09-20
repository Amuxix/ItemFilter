package me.amuxix.categories2
import me.amuxix.actions.Action
import me.amuxix.conditions.Condition
import me.amuxix.items.GenItem
import me.amuxix.items.bases.Base.flasks
import me.amuxix.{Common, FilterRarity, Leveling}

class Flasks extends AutomatedCategory {
  override protected val categoryItems: Seq[GenItem] =
    flasks
      .flatten
      .sortBy(_.dropLevel)(implicitly[Ordering[Int]].reverse)
      .map(flask => new GenItem(Leveling) { override protected def condition: Condition = flask.conditionsOfBestRaresForZoneLevel() }) :+
    new GenItem(Common) { override protected def condition: Condition = Condition(`class` = "Utility Flask") }

  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
    case _ => Action()
  }
}
