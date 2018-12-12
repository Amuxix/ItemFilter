package me.amuxix.categories.automated.currency

import me.amuxix._
import me.amuxix.actions.Color.{black, goodYellow, lightGreen}
import me.amuxix.actions.Sound.{chaos, myths, rare}
import me.amuxix.actions._
import me.amuxix.categories.automated.AutomatedCategory
import me.amuxix.conditions.{Condition, StackSize}
import me.amuxix.items.GenItem
import me.amuxix.items.currency.{Currency, Orb, Shard}

object Currency extends AutomatedCategory {
  private val rarities = Seq(Mythic, Epic, Rare, Uncommon, Common)
  override protected val categoryItems: Seq[GenItem] =
    (Orb.orbs ++ Shard.shards).flatMap { currency =>
      currency.chaosValuePerSlot.fold(Seq(currency)) { chaosValue =>
        rarities.collect {
          case rarity if rarity.threshold > chaosValue && rarity.threshold / chaosValue <= currency.stackSize =>
            val stack = math.ceil(rarity.threshold / chaosValue).toInt
            new Currency(currency.stackSize) {
              override lazy val chaosValuePerSlot: Option[Double] = Some(chaosValue * stack)
              override def condition: Condition = currency.condition.copy(stackSize = Some(StackSize(stack, currency.stackSize)))
            }
        }
      }
  }

  override protected def actionForRarity(rarity: FilterRarity): Action = rarity match {
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
        sound = rare,
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
        textColor = goodYellow.lighten,
        borderColor = goodYellow.lighten,
        beam = (Yellow, true),
      )
    case _ =>
      Action(
        size = 40,
        textColor = goodYellow.lighten
      )
  }
}
