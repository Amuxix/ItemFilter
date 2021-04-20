package me.amuxix

import cats.data.NonEmptyList
import cats.effect.IO
import cats.implicits._
import me.amuxix.categories.Category
import me.amuxix.categories.semiautomated.LastCall
import me.amuxix.providers.Provider

class FilterFactory(
  league: League,
  categories: NonEmptyList[Category],
  legacyCategories: NonEmptyList[Category],
  provider: Provider,
) {
  case class Filter(
    name: String,
    body: String,
    level: FilterLevel,
  )

  private val allCategories = if (league == Standard || league == Hardcore) {
    categories.concatNel(legacyCategories)
  } else {
    categories
  }

  private def lastCallBlock(filterLevel: FilterLevel) =
    LastCall.blocks(filterLevel, provider).map(_.write(filterLevel, useContinue = false))

  def create(filterLevel: FilterLevel): IO[Filter] = {
    for {
      (shown, hidden) <- allCategories.parTraverse { category =>
        IO(category.partitionHiddenAndShown(filterLevel, provider))
      }.map(_.toList.unzip)
      lastCall = lastCallBlock(filterLevel)
      filterName = s"Amuxix${filterLevel.suffix}"
      _ <- IO.println(s"Generating $filterName")
    } yield Filter(filterName, (shown ++ hidden ++ lastCall.toList).mkString, filterLevel)
  }
}