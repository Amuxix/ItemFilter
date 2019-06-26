package me.amuxix.stashtabs

import akka.actor.ActorSystem
import akka.stream.scaladsl.{Flow, Sink, Source}
import akka.stream.ActorMaterializer
import akka.NotUsed
import cats.data.EitherT
import cats.implicits.catsStdInstancesForFuture
import me.amuxix.providers.Provider.ParsableWSResponse
import me.amuxix.providers.ProviderError
import play.api.libs.ws.ahc.StandaloneAhcWSClient

import scala.concurrent.{ExecutionContext, Future}
import scala.language.postfixOps
import scala.util.Failure

object StashParser {
  implicit val system = ActorSystem()
  system.registerOnTermination {
    System.exit(0)
  }
  implicit val materializer = ActorMaterializer()
  val wsClient = StandaloneAhcWSClient(httpCache = None)
  implicit val ec = ExecutionContext.global

  def requestStashTab(id: String): EitherT[Future, ProviderError, StashPayload] = {
    val url = "http://www.pathofexile.com/api/public-stash-tabs"
    EitherT(
      wsClient.url(url)
        .withQueryStringParameters("id" -> id)
        .get()
        .map(_.parse[StashPayload](url))
    )
  }

  def main(args: Array[String]): Unit = {
    val itemNames = List("Lion's Roar")

    val stashes = Source.unfoldAsync("409471039-425037495-400311602-459859008-435733915") { id =>
      //print(id)
      requestStashTab(id).toOption.map {
        case StashPayload(nextId, stashes) =>
          //println(s" ${stashes.length}")
          (nextId, stashes)
      }.value
    }
      .mapConcat(identity)

    val parseStashes: Flow[Stash, String, NotUsed] =
      Flow[Stash]
        .collect {
          case Stash(_, true, _, Some(name), _, Some("Legion"), items) =>
            items.collect {
              case item if itemNames.contains(item.name) =>
                s"@$name Hi, I would like to buy your ${item.name}${item.note.fold("")(note => s" listed for $note")}"
            }
        }
        .mapConcat(identity)

    stashes
      .via(parseStashes)
      .runWith(Sink.foreach(println))
      .andThen {
        case _ =>
          wsClient.close()
          system.terminate()
      }
      .andThen {
        case Failure(ex) => throw ex
      }
  }
}
