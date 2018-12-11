package me.amuxix.providers

import cats.data.EitherT
import me.amuxix.items.currency.{ChaosOrb, PriceFallback}
import me.amuxix.items.{Item, NoDrop}
import me.amuxix.providers.Provider.ParsableWSResponse
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

  val itemPrices: mutable.Map[String, Double] = mutable.Map[String, Double]((ChaosOrb.name.toLowerCase, 1))

  def getChaosEquivalentFor(item: Item): Option[Double] =
    itemPrices
      .get(item.name.toLowerCase)
      .orElse(item match {
        case fallback: PriceFallback =>
          println(s"Using fallback price for ${fallback.name}")
          Some(fallback.fallback)
        case _: NoDrop =>
          None
        case other =>
          println(s"No Price for ${other.name}")
          None
      })
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
  def getAllItemsPrices: Future[_]
}

