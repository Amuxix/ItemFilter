package me.amuxix.providers

import cats.effect.IO
import me.amuxix.League

abstract class Provider {
  /**
    * This should get a map of all item names to their price for the given league
    */
  def getAllItemsPrices(league: League): IO[Map[String, Double]]
}
