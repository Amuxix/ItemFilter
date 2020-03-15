package me.amuxix.providers

import cats.effect.IO
import cats.implicits.{catsStdInstancesForFuture, catsStdInstancesForList, toTraverseOps}
import io.circe.{Decoder, HCursor}
import io.circe.generic.semiauto.deriveDecoder
import me.amuxix.League
import me.amuxix.providers.PoeNinja._
import org.http4s.client.Client
import org.http4s.Uri
import org.http4s.circe.CirceEntityDecoder.circeEntityDecoder
import org.http4s.implicits._

import scala.concurrent.{ExecutionContext, Future}

object PoeNinja {
  val baseURI: Uri = uri"https://poe.ninja/api/data" //TODO: Extract this to config

  private def readLines(currencyFieldName: String, priceFieldName: String): Decoder[Price] = (c: HCursor) =>
    for {
      name <- c.downField(currencyFieldName).as[String]
      price <- c.downField(priceFieldName).as[Double]
    } yield Price(name.toLowerCase.trim, price)

  val currencyLinesDecoder: Decoder[Price] = readLines("currencyTypeName", "chaosEquivalent")
  val itemLinesDecoder: Decoder[Price] = readLines("name", "chaosValue")

  case class PoENinjaResponse(lines: List[Price])

  implicit def decoder(implicit lineDecoder: Decoder[Price]): Decoder[PoENinjaResponse] = deriveDecoder
}

class PoeNinja(
  client: Client[IO],
  league: League,
)(
  implicit ec: ExecutionContext
) extends Provider {
  protected def getAllItemsPrices: Future[List[Price]] =
    List(
      ("Currency", baseURI / "currencyoverview", currencyLinesDecoder),
      ("Fragment", baseURI / "currencyoverview", currencyLinesDecoder),
      ("Essence", baseURI / "itemoverview", itemLinesDecoder),
      ("DivinationCard", baseURI / "itemoverview", itemLinesDecoder),
      ("Fossil", baseURI / "itemoverview", itemLinesDecoder),
      ("Resonator", baseURI / "itemoverview", itemLinesDecoder),
      ("Scarab", baseURI / "itemoverview", itemLinesDecoder),
      ("Map", baseURI / "itemoverview", itemLinesDecoder),
      ("Prophecy", baseURI / "itemoverview", itemLinesDecoder),
      //("UniqueMap", s"$baseURL/itemoverview", itemLinesDecoder),
      ("UniqueJewel", baseURI / "itemoverview", itemLinesDecoder),
      ("UniqueFlask", baseURI / "itemoverview", itemLinesDecoder),
      ("UniqueWeapon", baseURI / "itemoverview", itemLinesDecoder),
      ("UniqueArmour", baseURI / "itemoverview", itemLinesDecoder),
      ("UniqueAccessory", baseURI / "itemoverview", itemLinesDecoder),
      ("Incubator", baseURI / "itemoverview", itemLinesDecoder),
      ("Oil", baseURI / "itemoverview", itemLinesDecoder),
      ("Vial", baseURI / "itemoverview", itemLinesDecoder),
      ("Watchstone", baseURI / "itemoverview", itemLinesDecoder),
    )
      .flatTraverse {
        case (t, uri, decoder) =>
          implicit val d: Decoder[Price] = decoder
          val uriWithQueryParams = uri
            .withQueryParam("type", t)
            .withQueryParam("league", league)

          client.expect[PoENinjaResponse](uriWithQueryParams).map(_.lines).unsafeToFuture()
      }
}
