package me.amuxix.providers

import cats.effect.IO
import cats.implicits.{catsStdInstancesForList, toTraverseOps}
import io.circe.Decoder
import io.circe.generic.auto._
import io.circe.generic.semiauto.deriveDecoder
import me.amuxix.{ItemFilter, League}
import me.amuxix.ItemFilter.contextShift
import me.amuxix.providers.PoeNinja.{baseURL, Currency, Item, Response}
import org.http4s.circe.CirceEntityDecoder.circeEntityDecoder
import org.http4s.client.Client

object PoeNinja {
  val baseURL = "https://poe.ninja/api/data"
  case class Currency(currencyTypeName: String, chaosEquivalent: Double)
  case class Item(name: String, chaosValue: Double)
  case class Response[A](lines: List[A])
  implicit def decoder[A : Decoder]: Decoder[Response[A]] = deriveDecoder
}

class PoeNinja(client: Client[IO]) extends Provider {
  override def getAllItemsPrices(league: League): IO[Map[String, Double]] = {
    val currencyList = List("Currency", "Fragment")
    val itemList = List(
      "Essence",
      "DivinationCard",
      "Fossil",
      "Resonator",
      "Scarab",
      "Map",
      "Prophecy",
      "UniqueJewel",
      "UniqueFlask",
      "UniqueWeapon",
      "UniqueArmour",
      "UniqueAccessory",
      "Incubator",
      "Oil",
    )

    val currencies = currencyList.flatTraverse { currency =>
      client.expect[Response[Currency]](s"$baseURL/currencyoverview?league=${ItemFilter.league.name}&type=$currency")
        .map(_.lines.map(a => (a.currencyTypeName, a.chaosEquivalent)))
    }

    val items = itemList.flatTraverse { item =>
      client.expect[Response[Item]](s"$baseURL/itemoverview?league=${ItemFilter.league.name}&type=$item")
        .map(_.lines.map(a => (a.name, a.chaosValue)))
    }

    for {
      currencies <- currencies
      items <- items
    } yield (currencies ++ items).toMap + ("chaos orb" -> 1d)
  }
}
