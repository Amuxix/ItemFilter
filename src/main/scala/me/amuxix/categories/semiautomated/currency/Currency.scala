package me.amuxix.categories.semiautomated.currency

import cats.data.NonEmptyList
import me.amuxix._
import me.amuxix.actions._
import me.amuxix.actions.Color.{black, goodYellow, lightGreen}
import me.amuxix.actions.Sound.{armourKit, chaos, epic, myths}
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.{Condition, StackSize}
import me.amuxix.items.{Currency, GenericItem}
import me.amuxix.providers.Provider

object Currency extends SemiAutomatedCategory {
  private val rarities = List(Mythic, Epic, Rare, Uncommon, Common)
  override protected def categoryItems(provider: Provider): NonEmptyList[GenericItem] = {
    lazy val orbs = provider.currencies.orbs
    lazy val fragments = provider.currencyFragments.all
    lazy val vials = provider.currencies.vials
    lazy val catalysts = provider.currencies.catalysts
    lazy val orbsAndFragments = orbs.concatNel(fragments).flatMap { currency =>
      currency.chaosValuePerSlot(provider).fold(NonEmptyList.one[Currency](currency)) { chaosValue =>
        val increasedStackSizes = rarities
          .collect { case rarity if rarity.threshold > chaosValue && rarity.threshold / chaosValue <= currency.stackSize => val stack = math.ceil(rarity.threshold / chaosValue).toInt
            new Currency {
              override val stackSize: Int = currency.stackSize
              override val name: String = currency.name
              override val dropLevel: Int = currency.dropLevel
              override val dropEnabled: Boolean = currency.dropEnabled

              override def chaosValuePerSlot(provider: Provider): Option[Double] = Some(chaosValue * stack)

              override lazy val condition: Condition = currency.condition.copy(stackSize = Some(StackSize(stack, currency.stackSize)))
            }
          }
        NonEmptyList.ofInitLast(increasedStackSizes, currency)
      }
    }
    orbsAndFragments concatNel vials concatNel catalysts
  }

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
        textColor = goodYellow.lighten,
      )
  }
}
