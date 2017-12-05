package me.amuxix

case class InvalidArgument(message: String = "Argument outside legal range") extends Exception(message){

}
