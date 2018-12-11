package me.amuxix.providers

import play.api.libs.ws.StandaloneWSResponse

sealed abstract class ProviderError(errorMessage: String)

case class RequestError(url: String, response: StandaloneWSResponse, errorMessage: String) extends ProviderError(errorMessage)
case class ParsingError(errorMessage: String) extends ProviderError(errorMessage)
