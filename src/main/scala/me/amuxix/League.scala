package me.amuxix

import org.http4s.{QueryParamEncoder, QueryParameterValue}

sealed trait League

object League {
  implicit val queryParamEncoder: QueryParamEncoder[League] = (value: League) => QueryParameterValue(value.toString)
}

case object Metamorph extends League
case object MetamorphHardcore extends League
case object Hardcore extends League
case object Standard extends League
