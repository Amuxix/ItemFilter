package me.amuxix.categories.automated

import cats.data.NonEmptyList
import cats.effect.IO
import cats.implicits.{catsKernelStdOrderForString, catsStdInstancesForList, toTraverseOps}
import me.amuxix.FilterRarity.Priced._
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{black, unique, white}
import me.amuxix.actions.EffectColor.{Brown, Green}
import me.amuxix.actions.Shape.{Diamond, Hexagon, Star}
import me.amuxix.actions.Sound.{epic, myths, pileOfShit}
import me.amuxix.categories.AutomatedCategory
import me.amuxix.conditions.{Condition, Unique}
import me.amuxix.database
import me.amuxix.items.{Item, PurePrice}
import me.amuxix.FilterRarity.Priced

class Uniques(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]) extends AutomatedCategory {

  override protected lazy val items: IO[NonEmptyList[Item]] =
    database.Uniques.all.flatMap(
      items =>
        items
          .groupBy(_.baseName)
          .values
          .map { uniques =>
            val enabledUniques = uniques.filter(_.dropEnabled)
            val itemWithWeightedValue =
              enabledUniques.traverse(_.chaosValuePerSlot(prices, parentLeaguePrices))
                .map { uniqueValues =>
                  val uniqueWeights =
                    uniqueValues.map(value => 1 / math.pow(value, 1 / 3d))
                  val totalWeight = uniqueWeights.sum
                  val value = (uniqueValues zip uniqueWeights).foldLeft(0d) {
                    case (acc, (value, weight)) =>
                      val weightedDropChance = weight / totalWeight
                      acc + weightedDropChance * value

                  }
                  new Item with PurePrice {
                    override val dropLevel: Int = enabledUniques.map(_.dropLevel).min
                    override val dropEnabled: Boolean = true
                    override val name: String = ""
                    override val `class`: String = ""

                    override def condition: IO[Condition] =
                      IO.pure(
                        Condition(
                          base = enabledUniques.head.baseName,
                          rarity = Unique,
                        )
                      )
                    override def chaosValuePerSlot: Double = value
                  }
              }
            itemWithWeightedValue.getOrElseF(
              uniques
                .traverse(unique => unique.rarity(prices, parentLeaguePrices).map(unique -> _)) //For each unique get its rarity
                .map(_.toList.maxBy(_._2)._1)                                                   //Keep only the rarest
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
