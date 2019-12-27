package me.amuxix.providers

import cats.data.OptionT
import me.amuxix.items.Item

import scala.concurrent.{ExecutionContext, Future}

abstract class Provider(implicit ec: ExecutionContext) {

  private val itemPrices: Future[Map[String, Double]] = getAllItemsPrices.map { prices =>
    println("Got prices successfully")
    (("chaos orb", 1d) +: prices.map {
      case Price(name, chaosEquivalent) => name -> chaosEquivalent
    }).toMap
  }

  def getPriceOf(item: Item): OptionT[Future, Double] = OptionT(itemPrices.map(_.get(item.name.toLowerCase)))

  /**
    * This should update price for all items so they are accessible on itemPrices map
    */
  protected def getAllItemsPrices: Future[List[Price]]
}
