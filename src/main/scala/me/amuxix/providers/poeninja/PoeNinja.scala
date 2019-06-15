package me.amuxix.providers.poeninja

import cats.data.OptionT
import cats.implicits._
import me.amuxix.ItemFilter
import me.amuxix.items.CraftableBase
import me.amuxix.providers.{Price, Provider}
import me.amuxix.providers.poeninja.PoeNinja._
import me.amuxix.providers.poeninja.PoeNinjaResponse._
import play.api.libs.json.Reads
import play.api.libs.ws.StandaloneWSClient

import scala.concurrent.{ExecutionContext, Future}

object PoeNinja {
  val baseURL = "https://poe.ninja/api/data"
}

class PoeNinja(wsClient: StandaloneWSClient)(implicit ec: ExecutionContext) extends Provider(wsClient) {
  protected def getAllItemsPrices: OptionT[Future, List[Price]] = {
    val parameters: Seq[(String, String)] = Seq(
      "league" -> ItemFilter.league.toString
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
      ("Prophecy", s"$baseURL/itemoverview", readItemLines),
      //("UniqueMap", s"$baseURL/itemoverview", readItemLines),
      ("UniqueJewel", s"$baseURL/itemoverview", readItemLines),
      ("UniqueFlask", s"$baseURL/itemoverview", readItemLines),
      ("UniqueWeapon", s"$baseURL/itemoverview", readItemLines),
      ("UniqueArmour", s"$baseURL/itemoverview", readItemLines),
      ("UniqueAccessory", s"$baseURL/itemoverview", readItemLines),
      ("Incubator", s"$baseURL/itemoverview", readItemLines),
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
    prices.toOption
  }

  protected def getBasePrices: OptionT[Future, Map[CraftableBase, Price]] =
    ??? /*{
    val parameters: Seq[(String, String)] = Seq(
      "league" -> ItemFilter.league.toString
    )
    val routes = List(
      ("BaseType", s"$baseURL/itemoverview", readItemLines),
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
    prices.toOption
  }*/
}
