package me.amuxix.providers.poeninja

import cats.implicits._
import me.amuxix.ItemFilter
import me.amuxix.providers.Provider
import me.amuxix.providers.poeninja.PoeNinja._
import me.amuxix.providers.poeninja.Price._
import play.api.libs.json.Reads
import play.api.libs.ws.StandaloneWSClient

import scala.concurrent.{ExecutionContext, Future}

object PoeNinja {
  val baseURL = "https://poe.ninja/api/data"
}

class PoeNinja(wsClient: StandaloneWSClient)(implicit ec: ExecutionContext) extends Provider(wsClient) {
  def getAllItemsPrices: Future[_] = {
    val parameters: Seq[(String, String)] = Seq(
      "league" -> ItemFilter.league.toString
      //"date" -> date
    )
    val routes = Seq(
      ("Currency", s"$baseURL/currencyoverview", readCurrencyLines),
      ("Fragment", s"$baseURL/currencyoverview", readCurrencyLines),
      ("Essence", s"$baseURL/itemoverview", readItemLines),
      ("DivinationCard", s"$baseURL/itemoverview", readItemLines),
      ("Fossil", s"$baseURL/itemoverview", readItemLines),
      ("Resonator", s"$baseURL/itemoverview", readItemLines),
      ("Scarab", s"$baseURL/itemoverview", readItemLines),
      ("Map", s"$baseURL/itemoverview", readItemLines),
      //Uniques
      /*("UniqueMap", s"$baseURL/itemoverview", readItemLines),
      ("UniqueJewel", s"$baseURL/itemoverview", readItemLines),
      ("UniqueFlask", s"$baseURL/itemoverview", readItemLines),
      ("UniqueWeapon", s"$baseURL/itemoverview", readItemLines),
      ("UniqueArmour", s"$baseURL/itemoverview", readItemLines),
      ("UniqueAccessory", s"$baseURL/itemoverview", readItemLines),*/
    )
    val requests = routes.map {
      case (t, url, priceReader) =>
        implicit val reads: Reads[Price] = priceReader
        get[PoeNinjaResponse](url, parameters :+ "type" -> t: _*).map {
          _.lines.foreach {
            case Price(name, value) => Provider.itemPrices.update(name.toLowerCase.trim, value)
          }
        }.value
    }
    Future.sequence(requests)
  }
}
