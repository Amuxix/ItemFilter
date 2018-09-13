package me.amuxix.providers

import cats.data.{EitherT, OptionT}
import cats.implicits._
import me.amuxix.League
import me.amuxix.providers.Provider.ParsableWSResponse
import me.amuxix.items.Item
import me.amuxix.providers.poeninja.PoeNinja.defaultLeague
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
}

abstract class Provider(wsClient: StandaloneWSClient)(implicit ec: ExecutionContext) {
  private val requestsInProgress = mutable.Map.empty[(String, Seq[(String, String)]), Future[Either[ProviderError, Any]]]

  protected def get[Response](url: String, parameters: (String, String)*)(implicit reads: Reads[Response]): EitherT[Future, ProviderError, Response] = {
    EitherT(requestsInProgress.getOrElseUpdate((url, parameters), {
      println("making new request")
      println(requestsInProgress)
      val future = wsClient
        .url(url)
        .withQueryStringParameters(parameters.toSeq: _*)
        .get()
        .map(_.parse[Response](url))
      future.onComplete(_ => requestsInProgress.remove((url, parameters)))
      future
    }
    )).map(_.asInstanceOf[Response])
  }

  def getChaosEquivalentFor(item: Item, league: League = defaultLeague): OptionT[Future, Double]
}

