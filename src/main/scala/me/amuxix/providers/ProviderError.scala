package me.amuxix.providers

import play.api.libs.ws.StandaloneWSResponse

sealed abstract class ProviderError(val errorMessage: String)

case class RequestError(url: String, response: StandaloneWSResponse, _errorMessage: String) extends ProviderError(_errorMessage)
case class ParsingError(_errorMessage: String) extends ProviderError(_errorMessage)
