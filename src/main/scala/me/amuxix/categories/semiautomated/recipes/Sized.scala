package me.amuxix.categories.semiautomated.recipes

import cats.data.{NonEmptyList, OptionT}
import cats.effect.IO
import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.categories.SemiAutomatedCategory
import me.amuxix.conditions.Condition
import me.amuxix.items.{GenericItem, Price}

abstract class Sized extends SemiAutomatedCategory {
  def condition: Condition
  def chaosValue: OptionT[IO, Double]

  def generateGenericItem(height: Int, width: Int): GenericItem =
    Price(chaosValue.map(_ / (width * height)), condition.copy(height = height, width = width))

  override protected val categoryItems: IO[NonEmptyList[GenericItem]] =
    IO {
      NonEmptyList.fromListUnsafe(
        for {
          height <- List.range(2, 4)
          width <- List.range(1, 2)
        } yield generateGenericItem(height, width)
      )
    }


  override protected def actionForRarity: FilterRarity => Action = { _ =>
    Action()
  }
}
