package me.amuxix

import cats.data.NonEmptyList
import cats.effect.{ContextShift, IO}
import cats.implicits._
import me.amuxix.categories.Category
import me.amuxix.categories.semiautomated.LastCall

class FilterFactory(
  league: League,
  categories: NonEmptyList[Category],
  legacyCategories: NonEmptyList[Category],
)(
  implicit cs: ContextShift[IO],
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
    IO.fromFuture(IO(LastCall.blocks(filterLevel)))
      .map(_.map(_.write(filterLevel)))

  def create(filterLevel: FilterLevel): IO[Filter] = {
    for {
      (shown, hidden) <- allCategories.parTraverse { category =>
        IO.fromFuture(IO(category.partitionHiddenAndShown(filterLevel)))
      }.map(_.toList.unzip)
      lastCall <- lastCallBlock(filterLevel)
      filterName = s"Amuxix${filterLevel.suffix}"
    } yield {
      println(s"Generating $filterName")
      Filter(filterName, (shown ++ hidden ++ lastCall.toList).mkString, filterLevel)
    }
  }
}