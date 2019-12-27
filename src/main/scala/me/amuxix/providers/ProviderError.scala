package me.amuxix.providers

sealed abstract class ProviderError(val errorMessage: String)

case class RequestError(url: String, _errorMessage: String) extends ProviderError(_errorMessage)
case class ParsingError(_errorMessage: String) extends ProviderError(_errorMessage)
