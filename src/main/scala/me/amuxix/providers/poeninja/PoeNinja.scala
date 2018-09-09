package me.amuxix.providers.poeninja

import cats.implicits._
import cats.data.OptionT
import me.amuxix.items.currency._
import me.amuxix.items.{DivinationCard, Item}
import me.amuxix.providers.poeninja.PoeNinja._
import me.amuxix.providers.poeninja.Price._
import me.amuxix.providers.Provider
import me.amuxix.{Delve, ItemFilter, League}
import play.api.libs.json.Reads
import play.api.libs.ws.StandaloneWSClient

import scala.concurrent.{ExecutionContext, Future}

object PoeNinja {
  val date = "2018-09-07"
  val defaultLeague: League = Delve

  val baseURL = "https://poe.ninja/api/data"
}

class PoeNinja(wsClient: StandaloneWSClient)(implicit ec: ExecutionContext) extends Provider(wsClient) {
  def getChaosEquivalentFor(item: Item, league: League = defaultLeague): OptionT[Future, Double] = {
    val parameters: Seq[(String, String)] = Seq(
      "league" -> league.toString
      //"date" -> date
    )
    (item match {
      case _: Essence        => Some(("Essence", s"$baseURL/itemoverview", readItemLines))
      case _: Fragment       => Some(("Fragment", s"$baseURL/currencyoverview", readItemLines))
      case _: Orb            => Some(("Currency", s"$baseURL/currencyoverview", readCurrencyLines))
      case _: Shard[_]       => Some(("Currency", s"$baseURL/itemoverview", readCurrencyLines))
      case _: DivinationCard => Some(("DivinationCard", s"$baseURL/itemoverview", readItemLines))
      case _                 => None
    }).map {
        case (t, url, priceReader) =>
          implicit val reads: Reads[Price] = priceReader
          get[PoeNinjaResponse](url, parameters :+ "type" -> t: _*).map {
            _.lines.collectFirst {
              case Price(name, value) if name == item.name =>
                println(s"$name is worth $value")
                value
            }
          }
      }
      .fold[OptionT[Future, Double]](OptionT.fromOption(None))(_.toOption.subflatMap(identity))
  }
}
