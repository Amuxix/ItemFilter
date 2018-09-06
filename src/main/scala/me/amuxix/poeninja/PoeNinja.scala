package me.amuxix.poeninja

import cats.data.EitherT
import cats.implicits._
import me.amuxix.{Delve, ItemFilter, League}
import me.amuxix.items.currency._
import me.amuxix.items.{DivinationCard, Item}
import me.amuxix.poeninja.PoeNinja._
import play.api.libs.json.{JsValue, Reads}
import play.api.libs.ws.JsonBodyReadables._
import play.api.libs.ws.{StandaloneWSClient, StandaloneWSResponse}

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.ExecutionContext.global

object PoeNinja {
  val date = "2018-09-05"

  val baseURL = "https://poe.ninja/api/data"

  def main(args: Array[String]): Unit = {
    new PoeNinja(ItemFilter.wsClient())(global)
      .itemUrlAndType(ExaltedOrb, Delve)
      .foreach(
        _.value.foreach(
          _.foreach(
            _.foreach(
              println
            )
          )
        )(global)
      )
  }
}

class PoeNinja(wsClient: StandaloneWSClient)(implicit val ec: ExecutionContext) {
  implicit class ParsableWSResponse(response: StandaloneWSResponse) {
    def parse[Response](url: String)(implicit reads: Reads[Response]): Either[ProviderError, Response] =
      response match {
        case _ if response.body.isEmpty =>
          Left(RequestError(url, response, "Response is empty."))
        case _ if response.status >= 200 && response.status < 300 =>
          response.body[JsValue]
            .validate[Response]
            .asEither
            .left
            .map(errors => ParsingError(errors.toString))
        case _ =>
          Left(RequestError(url, response, s"Response returned a failed status code: ${response.status}"))}
  }

  private def get[Response](url: String, parameters: (String, String)*)(implicit reads: Reads[Response]): EitherT[Future, ProviderError, Response] = {
    EitherT(
      wsClient
        .url(url)
        .withQueryStringParameters(parameters.toSeq: _*)
        .get()
        .map(_.parse[Response](url))
    )
  }

  def itemUrlAndType(item: Item, league: League): Option[EitherT[Future, ProviderError, Option[Double]]] = {
    val parameters: Seq[(String, String)] = Seq(
      "league" -> league.toString,
      "date" -> date
    )
    item match {
      case _: Essence =>
        val url = s"$baseURL/itemoverview"
        implicit val reads: Reads[Price] = me.amuxix.poeninja.Price.readItemLines
        Some(
          get[Response](url, parameters :+ "type" -> "Essence": _*).map {
            _.lines.collectFirst {
              case Price(name, value) if name == item.name => value
            }
          }
        )

      case _: Fragment =>
        val url = s"$baseURL/currencyoverview"
        implicit val reads: Reads[Price] = me.amuxix.poeninja.Price.readCurrencyLines
        Some(
          get[Response](url, parameters :+ "type" -> "Essence": _*).map {
            _.lines.collectFirst {
              case Price(name, value) if name == item.name => value
            }
          }
        )

      case _: Orb =>
        val url = s"$baseURL/currencyoverview"
        implicit val reads: Reads[Price] = me.amuxix.poeninja.Price.readCurrencyLines
        Some(
          get[Response](url, parameters :+ "type" -> "Essence": _*).map {
            _.lines.collectFirst {
              case Price(name, value) if name == item.name => value
            }
          }
        )

      case _: Shard[_] =>
        val url = s"$baseURL/itemoverview"
        implicit val reads: Reads[Price] = me.amuxix.poeninja.Price.readItemLines
        Some(
          get[Response](url, parameters :+ "type" -> "Essence": _*).map {
            _.lines.collectFirst {
              case Price(name, value) if name == item.name => value
            }
          }
        )

      case _: DivinationCard =>
        val url = s"$baseURL/itemoverview"
        implicit val reads: Reads[Price] = me.amuxix.poeninja.Price.readItemLines
        Some(
          get[Response](url, parameters :+ "type" -> "Essence": _*).map {
            _.lines.collectFirst {
              case Price(name, value) if name == item.name => value
            }
          }
        )

      case _ => None
    }
  }

  def getChaosEquivalentFor(item: Item, league: League): Option[Double] = {
    //Future.sequence(itemUrlAndType(item, league).map(_.value))
    ???
  }
}
