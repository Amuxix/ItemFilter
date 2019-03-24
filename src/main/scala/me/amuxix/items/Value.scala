package me.amuxix.items
import cats.data.OptionT
import cats.implicits._
import me.amuxix._
import me.amuxix.ItemFilter.ec

import scala.concurrent.Future

trait Value {
  def chaosValuePerSlot: OptionT[Future, Double]

  lazy val rarity: Future[FilterRarity] =
    chaosValuePerSlot.fold[FilterRarity](Undetermined) { chaosValuePerSlot =>
      if (chaosValuePerSlot >= Mythic.threshold) Mythic
      else if (chaosValuePerSlot >= Epic.threshold) Epic
      else if (chaosValuePerSlot >= Rare.threshold) Rare
      else if (chaosValuePerSlot >= Uncommon.threshold) Uncommon
      else if (chaosValuePerSlot >= Common.threshold) Common
      else Leveling //The price is lower than the lowest threshold.
    }
}
