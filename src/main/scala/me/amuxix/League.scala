package me.amuxix

sealed trait League

case object Legion extends League
case object LegionHardcore extends League
case object Hardcore extends League
case object Standard extends League
