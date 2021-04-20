package me.amuxix.categories.semiautomated

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.GenericItem
import me.amuxix.providers.Provider

object Heist extends SemiAutomatedCategory {

  protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = provider.heistEquipment.all :+ new GenericItem {
    override def rarity(provider: Provider): FilterRarity = AlwaysShow
    override lazy val condition: Condition = Condition(`class` = Seq("Contract", "Blueprint"))
  }

  override protected def actionForRarity: FilterRarity => Action = _ => Action()
 /* override protected def actionForRarity: FilterRarity => Action = {
    case AlwaysHide   => Action()
    case AlwaysShow   => Action(size = 45, beam = Green)
    case Undetermined => Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow)
    case Mythic       => Action(size = 45, sound = Sound.myths, borderColor = red, backgroundColor = white, textColor = red)
    case _ => //5Linkeds and 6 sockets
      Action(size = 45, sound = Sound.epic, borderColor = red)
  }*/
}
