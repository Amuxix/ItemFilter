package me.amuxix.providers.poeninja

import play.api.libs.functional.syntax._
import play.api.libs.json._

case class Price(
    name: String,
    chaosEquivalent: Double,
)

object Price {
  val readCurrencyLines: Reads[Price] = (
    (JsPath \ "currencyTypeName").read[String] and
      (JsPath \ "chaosEquivalent").read[Double]
  )(Price.apply _)
  val readItemLines: Reads[Price] = (
    (JsPath \ "name").read[String] and
      (JsPath \ "chaosValue").read[Double]
  )(Price.apply _)
}

case class PoeNinjaResponse(
    lines: Seq[Price],
)

object PoeNinjaResponse {
  implicit def responseReader(implicit reads: Reads[Price]): Reads[PoeNinjaResponse] = Json.reads
}
