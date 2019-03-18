package me.amuxix.items

import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter.ec
import me.amuxix.conditions.{Condition, Unique}
import me.amuxix.database.Bases

import scala.concurrent.Future

case class UniqueItem(_name: String, baseName: String, _dropEnabled: Boolean) extends GenItem(_name, _dropEnabled) with ProviderPrice {
  lazy val base: OptionT[Future, Base] = OptionT(Bases.all.map(_.find(_.name == baseName)))

  lazy val area: OptionT[Future, Int] = base.map { base =>
    base.height * base.width
  }

  override lazy val condition: Future[Condition] =
    base.map { base =>
      Condition(
        base = base.name,
        rarity = Unique
      )
    }.value.map(_.get)
}
