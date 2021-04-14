package me.amuxix.categories.automated

import cats.data.{NonEmptyList, OptionT}
import cats.implicits._
import me.amuxix._
import me.amuxix.ItemFilter.ec
import me.amuxix.actions._
import me.amuxix.actions.Color.{black, unique, white}
import me.amuxix.actions.Sound.{epic, myths, pileOfShit}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.conditions.{Condition, Unique}
import me.amuxix.items.{Item, Value}

import scala.concurrent.Future

object Uniques extends AutomatedCategory {

  override protected lazy val items: Future[NonEmptyList[Item]] =
    database.Uniques.all.flatMap(
      _.groupBy(_.baseName)
        .values
        .map { uniques =>
          val enabledUniques = uniques.filter(_.dropEnabled)
          val itemWithWeightedValue =
            enabledUniques
              .traverse(unique => unique.chaosValuePerSlot.map(_ -> unique.league))
              .map { uniqueValues =>
                val uniqueWeights = uniqueValues.map {
                  case (value, league) =>
                    val v = league.fold(value)(_ => value * 2) //Increase value of league specific to reduce their weight
                    1 / math.pow(v, 1 / 3d)
                }
                val totalWeight = uniqueWeights.sum
                val value = (uniqueValues.map(_._1) zip uniqueWeights).foldLeft(0d) {
                  case (acc, (value, weight)) =>
                    val weightedDropChance = weight / totalWeight
                    acc + weightedDropChance * value
                }
                new Item with Value {
                  override val dropLevel: Int = enabledUniques.map(_.dropLevel).min
                  override val dropEnabled: Boolean = true
                  override val name: String = ""
                  override val `class`: String = ""

                  override def condition: Future[Condition] =
                    Future.successful(
                      Condition(
                        base = enabledUniques.head.baseName,
                        rarity = Unique,
                      )
                    )
                  override def chaosValuePerSlot: OptionT[Future, Double] =
                    OptionT.pure(value)
                }
              }
          itemWithWeightedValue.getOrElseF(
            uniques
              .traverse(unique => unique.rarity.map(unique -> _)) //For each unique get its rarity
              .map(_.toList.maxBy(_._2)._1)                       //Keep only the rarest
          )
        }
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
