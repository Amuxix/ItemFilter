package me.amuxix

sealed trait League

case object Delve extends League
case object DelveHardcore extends League
case object Hardcore extends League
case object Standard extends League
