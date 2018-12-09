package me.amuxix.providers

import cats.data.EitherT
import me.amuxix.items.Item
import me.amuxix.providers.Provider.{ParsableWSResponse, defaultLeague}
import me.amuxix.{Betrayal, League}
import play.api.libs.json.{JsValue, Reads}
import play.api.libs.ws.JsonBodyReadables._
import play.api.libs.ws.{StandaloneWSClient, StandaloneWSResponse}

import scala.collection.mutable
import scala.concurrent.{ExecutionContext, Future}

object Provider {
  implicit class ParsableWSResponse(response: StandaloneWSResponse) {
    def parse[Response](url: String)(implicit reads: Reads[Response]): Either[ProviderError, Response] =
      response match {
        case _ if response.body.isEmpty =>
          Left(RequestError(url, response, "Response is empty."))
        case _ if response.status >= 200 && response.status < 300 =>
          response
            .body[JsValue]
            .validate[Response]
            .asEither
            .left
            .map(errors => ParsingError(errors.toString))
        case _ =>
          Left(RequestError(url, response, s"Response returned a failed status code: ${response.status}"))
      }
  }
  val defaultLeague: League = Betrayal

  val itemPrices = mutable.Map.empty[String, Double]

  def getChaosEquivalentFor(item: Item, league: League = defaultLeague): Option[Double] = {
    if (itemPrices.contains(item.name.toLowerCase) == false) println(s"No Price for ${item.name}")
    itemPrices.get(item.name.toLowerCase)
  }
}

abstract class Provider(wsClient: StandaloneWSClient)(implicit ec: ExecutionContext) {
  protected def get[Response](url: String, parameters: (String, String)*)(implicit reads: Reads[Response]): EitherT[Future, ProviderError, Response] =
    EitherT(
      wsClient
        .url(url)
        .withQueryStringParameters(parameters.toSeq: _*)
        .get()
        .map(_.parse[Response](url))
    )

  /**
    * This should update price for all items so they are accessible on itemPrices map
    */
  def getAllItemsPrices(league: League = defaultLeague): Future[_]
}

