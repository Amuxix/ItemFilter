package me.amuxix.providers

import cats.data.{EitherT, OptionT}
import me.amuxix.providers.Provider.ParsableWSResponse
import play.api.libs.json.{JsValue, Reads}
import play.api.libs.ws.{StandaloneWSClient, StandaloneWSResponse}
import play.api.libs.ws.JsonBodyReadables._

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
}

abstract class Provider(wsClient: StandaloneWSClient)(implicit ec: ExecutionContext) {
  protected def get[Response : Reads](url: String, parameters: (String, String)*): EitherT[Future, ProviderError, Response] = {
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
