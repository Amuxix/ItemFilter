package me.amuxix.categories.semiautomated.currency

import cats.data.{NonEmptyList, OptionT}
import cats.implicits._
import me.amuxix._
import me.amuxix.ItemFilter.ec
import me.amuxix.actions._
import me.amuxix.actions.Color.{black, goodYellow, lightGreen}
import me.amuxix.actions.Sound.{armourKit, chaos, epic, myths}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, StackSize}
import me.amuxix.database.{Currencies, CurrencyFragments}
import me.amuxix.items.{Currency, GenericItem}

import scala.concurrent.Future

object Currency extends SemiAutomatedCategory {
  private val rarities = List(Mythic, Epic, Rare, Uncommon, Common)
  override protected val categoryItems: Future[NonEmptyList[GenericItem]] =
    for {
      orbs <- Currencies.orbs
      fragments <- CurrencyFragments.all
      vials <- Currencies.vials
      orbsAndFragments <- orbs.concatNel(fragments).flatTraverse { currency =>
        currency.chaosValuePerSlot.fold(NonEmptyList.one[Currency](currency)) { chaosValue =>
          val increasedStackSizes = rarities.collect {
            case rarity if rarity.threshold > chaosValue && rarity.threshold / chaosValue <= currency.stackSize =>
              val stack = math.ceil(rarity.threshold / chaosValue).toInt
              new Currency {
                override val stackSize: Int = currency.stackSize
                override val name: String = currency.name
                override val dropLevel: Int = currency.dropLevel
                override val dropEnabled: Boolean = currency.dropEnabled
                override lazy val chaosValuePerSlot: OptionT[Future, Double] =
                  OptionT.pure(chaosValue * stack)
                override lazy val condition: Future[Condition] =
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
