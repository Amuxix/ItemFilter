package me.amuxix.providers.poeninja

import cats.implicits._
import cats.data.{EitherT, OptionT}
import me.amuxix.items.currency._
import me.amuxix.items.{DivinationCard, Item}
import me.amuxix.providers.poeninja.PoeNinja._
import me.amuxix.providers.poeninja.Price._
import me.amuxix.providers.{Provider, ProviderError}
import me.amuxix.{Delve, ItemFilter, League}
import play.api.libs.json.Reads
import play.api.libs.ws.StandaloneWSClient

import scala.collection.mutable
import scala.concurrent.{ExecutionContext, Future}

object PoeNinja {
  val date = "2018-09-07"
  val defaultLeague: League = Delve

  val baseURL = "https://poe.ninja/api/data"

  private val cache = mutable.Map.empty[String, Double]
}

class PoeNinja(wsClient: StandaloneWSClient)(implicit ec: ExecutionContext) extends Provider(wsClient) {
  def updateCacheFor(item: Item, league: League = defaultLeague): Future[Unit] = {
    println(s"Updating cache for ${item.name}")
    val parameters: Seq[(String, String)] = Seq(
      "league" -> league.toString
      //"date" -> date
    )
    val maybe: Option[Future[Either[ProviderError, Unit]]] = (item match {
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
          _.lines.foreach {
            case Price(name, value) => cache.update(name, value)
          }
        }.value
    }
    Future.sequence(maybe.toIterable).map(_ => ())
  }

  override def getChaosEquivalentFor(item: Item, league: League): OptionT[Future, Double] = {
    println(s"Getting price for ${item.name}")
    OptionT {
      (
        if (cache.contains(item.name) != false) Future.successful(())
        else updateCacheFor(item, league)
        )
        .map(_ => cache.get(item.name))
    }
  }
}
