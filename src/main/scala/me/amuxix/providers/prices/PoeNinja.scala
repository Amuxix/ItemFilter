package me.amuxix.providers.prices

import cats.effect.IO
import cats.instances.list._
import cats.syntax.traverse._
import io.circe.{Decoder, HCursor}
import io.circe.generic.semiauto.deriveDecoder
import me.amuxix.League
import me.amuxix.providers.prices.PoeNinja._
import org.http4s.client.Client
import org.http4s.Uri
import org.http4s.circe.CirceEntityDecoder.circeEntityDecoder
import org.http4s.implicits._

object PoeNinja {
  val baseURI: Uri = uri"https://poe.ninja/api/data"

  private def readLines(currencyFieldName: String, priceFieldName: String): Decoder[Price] = (c: HCursor) =>
    for {
      name <- c.downField(currencyFieldName).as[String]
      price <- c.downField(priceFieldName).as[Double]
    } yield Price(name.toLowerCase.trim, price)

  private val currencyLinesDecoder: Decoder[Price] = readLines("currencyTypeName", "chaosEquivalent")
  private val itemLinesDecoder: Decoder[Price] = readLines("name", "chaosValue")

  case class PoENinjaResponse(lines: List[Price])

  implicit def decoder(implicit lineDecoder: Decoder[Price]): Decoder[PoENinjaResponse] = deriveDecoder
}

class PoeNinja(
  client: Client[IO],
  league: League,
) extends Provider {
  override def prices: IO[List[Price]] =
    List(
      //General
      ("Currency", baseURI / "currencyoverview", currencyLinesDecoder),
      ("Fragment", baseURI / "currencyoverview", currencyLinesDecoder),
      ("DivinationCard", baseURI / "itemoverview", itemLinesDecoder),
      ("Oil", baseURI / "itemoverview", itemLinesDecoder),
      ("Incubator", baseURI / "itemoverview", itemLinesDecoder),
      ("Prophecy", baseURI / "itemoverview", itemLinesDecoder),
      //Equipment and Gems
      ("UniqueWeapon", baseURI / "itemoverview", itemLinesDecoder),
      ("UniqueArmour", baseURI / "itemoverview", itemLinesDecoder),
      ("UniqueAccessory", baseURI / "itemoverview", itemLinesDecoder),
      ("UniqueFlask", baseURI / "itemoverview", itemLinesDecoder),
      ("UniqueJewel", baseURI / "itemoverview", itemLinesDecoder),
      //Atlas
      ("Map", baseURI / "itemoverview", itemLinesDecoder),
      //Blighted Maps
      //("UniqueMap", s"$baseURL/itemoverview", itemLinesDecoder),
      ("DeliriumOrb", baseURI / "itemoverview", itemLinesDecoder),
      //Invitations
      ("Scarab", baseURI / "itemoverview", itemLinesDecoder),
      ("Watchstone", baseURI / "itemoverview", itemLinesDecoder),
      //Crafting
      ("Fossil", baseURI / "itemoverview", itemLinesDecoder),
      ("Resonator", baseURI / "itemoverview", itemLinesDecoder),
      ("Essence", baseURI / "itemoverview", itemLinesDecoder),
      ("Vial", baseURI / "itemoverview", itemLinesDecoder),
    )
      .flatTraverse {
        case (t, uri, decoder) =>
          implicit val d: Decoder[Price] = decoder
          val uriWithQueryParams = uri
            .withQueryParam("type", t)
            .withQueryParam("league", league)

          client.expect[PoENinjaResponse](uriWithQueryParams).map(_.lines)
      }
}
