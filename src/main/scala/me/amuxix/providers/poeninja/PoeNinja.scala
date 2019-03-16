package me.amuxix.providers.poeninja

import cats.implicits._
import me.amuxix.ItemFilter
import me.amuxix.providers.poeninja.PoeNinja._
import me.amuxix.providers.poeninja.PoeNinjaResponse._
import me.amuxix.providers.{Price, Provider}
import play.api.libs.json.Reads
import play.api.libs.ws.StandaloneWSClient

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.language.postfixOps

object PoeNinja {
  val baseURL = "https://poe.ninja/api/data"
}

class PoeNinja(wsClient: StandaloneWSClient)(implicit ec: ExecutionContext) extends Provider(wsClient) {
  protected def getAllItemsPrices: List[Price] = {
    val parameters: Seq[(String, String)] = Seq(
      "league" -> ItemFilter.league.toString
      //"date" -> date
    )
    val routes = List(
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
    val prices = routes.flatTraverse {
      case (t, url, priceReader) =>
        implicit val reads: Reads[Price] = priceReader
        get[PoeNinjaResponse](url, parameters :+ "type" -> t: _*).map {
          _.lines.map {
            case Price(name, value) => Price(name.toLowerCase.trim, value)
          }
        }
    }

    /*def waitForPrices: List[Price] =
      Try(Await.result(prices.value, 10 seconds))
        .collect { case Right(prices) => prices }
        .getOrElse {
          println("Failed to get prices, retrying")
          waitForPrices
        }*/

    def recover: Future[List[Price]] = {
      prices.value
        .collect{ case Right(prices) => prices }
        .recoverWith {
        case _ => recover
      }
    }

    Await.result(recover, 10 seconds)
  }
}
