package me.amuxix.categories
import cats.data.NonEmptyList
import cats.effect.IO
import me.amuxix._
import me.amuxix.actions._
import me.amuxix.actions.Color.black
import me.amuxix.items.{GenericItem, Item}
import me.amuxix.FilterRarity.{Priced, Undetermined}
import me.amuxix.FilterRarity.Priced._
import me.amuxix.actions.Shape.{Diamond, Hexagon, Star, Triangle}

trait AutomatedCategory extends SemiAutomatedCategory {
  protected def items: IO[NonEmptyList[Item]]
  protected def action: Priced => Action
  /*
  rarity match {
    case Common =>
    case Uncommon =>
    case Rare =>
    case Epic =>
    case Mythic =>
  }
   */

  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    items.map(items => NonEmptyList.fromListUnsafe(items.filter(_.dropEnabled)))
  override protected def actionForRarity: FilterRarity => Action = {
    case priced: Priced => action(priced)
    case `Undetermined` =>
      println("Assuming mythic rarity for item without price.")
      action(Mythic)
    case rarity =>
      throw new MatchError(s"Found $rarity but Automated Categories can only have Priced rarities")
  }
}

object AutomatedCategory extends ImplicitConversions {

  def automaticAction(color: Color, beamAndIconColor: EffectColor): Priced => Action = {
    case Common =>
      Action(
        backgroundColor = black,
        textColor = color,
      )
    case Uncommon =>
      Action(
        size = 36,
        backgroundColor = black,
        textColor = color.darken,
        borderColor = color.darken,
        minimapIcon = (beamAndIconColor, Triangle),
        beam = (beamAndIconColor, true),
      )
    case Rare =>
      Action(
        size = 36,
        backgroundColor = black,
        textColor = color,
        borderColor = color,
        minimapIcon = (beamAndIconColor, Diamond),
        beam = (beamAndIconColor, true),
      )
    case Epic =>
      Action(
        size = 40,
        backgroundColor = color.darken,
        textColor = black,
        borderColor = black,
        minimapIcon = (beamAndIconColor, Hexagon),
        beam = beamAndIconColor,
      )
    case _ =>
      Action(
        size = 45,
        backgroundColor = color,
        textColor = black,
        borderColor = black,
        minimapIcon = (beamAndIconColor, Star),
        beam = beamAndIconColor,
      )
  }

  def automaticActionWithSound(
    color: Color,
    sound: Sound,
    goodSound: Sound,
    beamAndIconColor: EffectColor,
  ): Priced => Action = {
    case Common =>
      Action(
        backgroundColor = black,
        textColor = color,
      )
    case Uncommon =>
      Action(
        size = 36,
        sound = sound,
        backgroundColor = black,
        textColor = color.darken,
        borderColor = color.darken,
        minimapIcon = (beamAndIconColor, Triangle),
        beam = (beamAndIconColor, true),
      )
    case Rare =>
      Action(
        size = 36,
        sound = sound,
        backgroundColor = black,
        textColor = color,
        borderColor = color,
        minimapIcon = (beamAndIconColor, Diamond),
        beam = (beamAndIconColor, true),
      )
    case Epic =>
      Action(
        size = 40,
        sound = goodSound,
        backgroundColor = color.darken,
        textColor = black,
        borderColor = black,
        minimapIcon = (beamAndIconColor, Hexagon),
        beam = beamAndIconColor,
      )
    case _ =>
      Action(
        size = 45,
        sound = goodSound,
        backgroundColor = color,
        textColor = black,
        borderColor = black,
        minimapIcon = (beamAndIconColor, Star),
        beam = beamAndIconColor,
      )
  }
}
