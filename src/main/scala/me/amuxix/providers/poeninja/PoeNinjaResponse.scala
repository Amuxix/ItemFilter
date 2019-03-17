package me.amuxix.providers.poeninja

import me.amuxix.providers.Price
import play.api.libs.functional.syntax._
import play.api.libs.json._

case class PoeNinjaResponse(
    lines: List[Price],
)

object PoeNinjaResponse {
  val readCurrencyLines: Reads[Price] = (
    (JsPath \ "currencyTypeName").read[String] and
      (JsPath \ "chaosEquivalent").read[Double]
  )(Price.apply _)

  val readItemLines: Reads[Price] = (
    (JsPath \ "name").read[String] and
      (JsPath \ "chaosValue").read[Double]
  )(Price.apply _)

  implicit def responseReader(implicit reads: Reads[Price]): Reads[PoeNinjaResponse] = Json.reads
}
