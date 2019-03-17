package me.amuxix.providers

import cats.data.{EitherT, OptionT}
import cats.implicits._
import me.amuxix.ItemFilter
import me.amuxix.ItemFilter.ec
import me.amuxix.items.{GenItem, NoPrice, PriceFallback}
import me.amuxix.providers.Provider.ParsableWSResponse
import play.api.libs.json.{JsValue, Reads}
import play.api.libs.ws.JsonBodyReadables._
import play.api.libs.ws.{StandaloneWSClient, StandaloneWSResponse}

import scala.concurrent.{ExecutionContext, Future}

object Provider {
  implicit class ParsableWSResponse(response: StandaloneWSResponse) {
    def parse[Response: Reads](url: String): Either[ProviderError, Response] =
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

  def getChaosEquivalentFor(item: GenItem): OptionT[Future, Double] =
    OptionT(ItemFilter.provider.itemPrices.map(_.get(item.name.toLowerCase)))
      .orElse(item match {
        case fallback: PriceFallback =>
          println(s"Using fallback price for ${fallback.name}")
          fallback.fallback
        case unpriced: NoPrice =>
          println(s"$unpriced is unpriced")
          OptionT.none
        case other =>
          println(s"No Price for ${other.name}")
          OptionT.none
      })
}

abstract class Provider(wsClient: StandaloneWSClient)(implicit ec: ExecutionContext) {
  protected def get[Response: Reads](url: String, parameters: (String, String)*): EitherT[Future, ProviderError, Response] = {
    val request = wsClient
      .url(url)
      .withQueryStringParameters(parameters.toSeq: _*)
    EitherT(
      request
        .get()
        .map(_.parse[Response](url))
    )
  }

  val itemPrices: Future[Map[String, Double]] = getAllItemsPrices.value.map {
    case Some(prices) =>
      println("Got prices successfully")
      (("chaos orb", 1D) +: prices.map {
        case Price(name, chaosEquivalent) => name -> chaosEquivalent
      }).toMap
    case None => throw new Exception("Failed to get prices")
  }

  /**
    * This should update price for all items so they are accessible on itemPrices map
    */
  protected def getAllItemsPrices: OptionT[Future, List[Price]]
}
