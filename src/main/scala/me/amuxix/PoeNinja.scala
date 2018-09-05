package me.amuxix
import me.amuxix.PoeNinja._
import me.amuxix.items.{DivinationCard, Item}
import me.amuxix.items.currency.{Essence, Fragment, Orb, Shard}

object PoeNinja {
  val league = "Delve"
  val date = "2018-09-05"

  val currency = s"https://poe.ninja/api/data/currencyoverview?league=$league&type=Currency&date=$date"
  val fragment = s"https://poe.ninja/api/data/currencyoverview?league=$league&type=Fragment&date=$date"
  val fossil = s"https://poe.ninja/api/data/itemoverview?league=$league&type=Fossil&date=$date"
  val resonator = s"https://poe.ninja/api/data/itemoverview?league=$league&type=Resonator&date=$date"
  val essence = s"https://poe.ninja/api/data/itemoverview?league=$league&type=Essence&date=$date"
  val divinationCard = s"https://poe.ninja/api/data/itemoverview?league=$league&type=DivinationCard&date=$date"
}

class PoeNinja {
  def itemRoute(item: Item): Option[String] = item match {
    case _: Essence => Some(essence)
    case _: Fragment => Some(fragment)
    case _: Orb => Some(currency)
    case _: Shard[_] => Some(currency)
    case _: DivinationCard => Some(divinationCard)
    case _ => None
  }
  def getChaosEquivalentFor(item: Item): Option[Double] = {
    val _ = item.toString
    ???
  }
}
