package me.amuxix

sealed trait League

case object Blight extends League
case object BlightHardcore extends League
case object Hardcore extends League
case object Standard extends League
