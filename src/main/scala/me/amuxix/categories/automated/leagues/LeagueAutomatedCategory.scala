package me.amuxix.categories.automated.leagues
import me.amuxix.ItemFilter.ec
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.{Base, CategoryItem, GenItem}
import me.amuxix.{AlwaysShow, Epic, Rare}

import scala.concurrent.Future

trait LeagueAutomatedCategory extends AutomatedCategory { outer =>
  val condition: Condition

  override protected val categoryItems: Future[Seq[GenItem]] =
    for {
      bestItems <- Base.bestItems
      allEquipment <- Base.allEquipment
    } yield {
      bestItems.map(base =>
        new CategoryItem(Epic) { override def condition: Condition = base.rare.join(outer.condition) },
      ) ++ allEquipment.flatMap( base =>
        Seq(
          new CategoryItem(Rare) { override def condition: Condition = base.conditionsOfBestRaresForZoneLevel.join(outer.condition) },
          new CategoryItem(AlwaysShow) { override def condition: Condition = base.conditionsOfGoodRaresForZoneLevel.join(outer.condition) },
        )
      ) ++ Seq(
        new CategoryItem(AlwaysShow) { override def condition: Condition = outer.condition }
      )
    }

}
