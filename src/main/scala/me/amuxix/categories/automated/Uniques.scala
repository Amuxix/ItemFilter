package me.amuxix.categories.automated

import cats.data.NonEmptyList
import cats.implicits._
import me.amuxix._
import me.amuxix.ItemFilter.ec
import me.amuxix.actions._
import me.amuxix.actions.Color.{black, unique, white}
import me.amuxix.actions.Sound.{epic, myths, pileOfShit}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.items.UniqueItem

import scala.concurrent.Future

object Uniques extends AutomatedCategory {
  override protected lazy val items: Future[NonEmptyList[UniqueItem]] =
    database.Uniques.all.flatMap( _.groupBy(_.baseName)
      .mapValues { uniques =>
        uniques
          .traverse(unique => unique.rarity.map(unique -> _))
          .map(_.toList.maxBy(_._2)._1)
      }
      .values
      .toList
      .sequence
      .map(NonEmptyList.fromListUnsafe)
  )

  override protected def action: Priced => Action = {
    case Mythic =>
      Action(
        size = 45,
        sound = myths,
        backgroundColor = white,
        textColor = unique,
        borderColor = unique,
        minimapIcon = (Green, Star),
        beam = Green,
      )
    case Epic =>
      Action(
        size = 45,
        sound = epic,
        backgroundColor = unique,
        textColor = black,
        minimapIcon = (Brown, Hexagon),
        beam = Brown,
      )
    case Rare =>
      Action(
        size = 40,
        sound = epic,
        backgroundColor = unique,
        textColor = black,
        minimapIcon = (Brown, Diamond),
        beam = (Brown, true),
      )
    case Leveling =>
      Action(
        size = 18,
        backgroundColor = black.halfTransparent,
        borderColor = unique.halfTransparent,
      )
    case _ =>
      Action(
        borderColor = unique,
        beam = (Brown, true),
        sound = pileOfShit,
      )
  }
}
