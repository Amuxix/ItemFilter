package me.amuxix.categories.semiautomated.currency

import cats.data.NonEmptyList
import cats.effect.IO
import cats.implicits.toTraverseOps
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{black, goodYellow, lightGreen}
import me.amuxix.actions.EffectColor._
import me.amuxix.actions.Sound.{armourKit, chaos, epic, myths}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, StackSize}
import me.amuxix.database.{Currencies, CurrencyFragments}
import me.amuxix.items.{GenericItem, PurePrice, Currency => CurrencyItem}
import me.amuxix.FilterRarity
import me.amuxix.FilterRarity.Priced._
import me.amuxix.actions.Shape.{Diamond, Hexagon, Star}

class Currency(prices: Map[String, Double], parentLeaguePrices: Map[String, Double]) extends SemiAutomatedCategory {
  private val rarities = List(Mythic, Epic, Rare, Uncommon, Common)
  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    for {
      orbs <- Currencies.orbs
      fragments <- CurrencyFragments.all
      vials <- Currencies.vials
      orbsAndFragments <- orbs.concatNel(fragments).flatTraverse { currency =>
        currency.chaosValuePerSlot(prices, parentLeaguePrices).fold(NonEmptyList.one[CurrencyItem](currency)) { chaosValue =>
          val increasedStackSizes = rarities.collect {
            case rarity if rarity.threshold > chaosValue && rarity.threshold / chaosValue <= currency.stackSize =>
              val stack = math.ceil(rarity.threshold / chaosValue).toInt
              new CurrencyItem with PurePrice {
                override val stackSize: Int = currency.stackSize
                override val name: String = currency.name
                override val dropLevel: Int = currency.dropLevel
                override val dropEnabled: Boolean = currency.dropEnabled
                override lazy val chaosValuePerSlot: Double = chaosValue * stack
                override lazy val condition: IO[Condition] =
                  currency.condition.map(_.copy(stackSize = Some(StackSize(stack, currency.stackSize))))
              }
          }
          NonEmptyList.ofInitLast(increasedStackSizes, currency)
        }
      }
    } yield orbsAndFragments concatNel vials

  override protected def actionForRarity: FilterRarity => Action = {
    case Mythic =>
      Action(
        size = 45,
        sound = myths,
        backgroundColor = lightGreen,
        textColor = black,
        borderColor = black,
        minimapIcon = (Green, Star),
        beam = Green,
      )
    case Epic =>
      Action(
        size = 45,
        sound = epic,
        backgroundColor = black,
        textColor = goodYellow,
        borderColor = goodYellow,
        minimapIcon = (Yellow, Star),
        beam = Yellow,
      )
    case Rare =>
      Action(
        size = 45,
        sound = chaos,
        textColor = goodYellow,
        borderColor = goodYellow,
        minimapIcon = (Yellow, Hexagon),
        beam = Yellow,
      )
    case Uncommon =>
      Action(
        size = 45,
        sound = armourKit,
        textColor = goodYellow.lighten,
        borderColor = goodYellow.lighten,
        minimapIcon = (Yellow, Diamond),
        beam = (Yellow, true),
      )
    case _ =>
      Action(
        size = 40,
        textColor = goodYellow.lighten
      )
  }
}
