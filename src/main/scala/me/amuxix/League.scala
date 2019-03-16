package me.amuxix

sealed trait League

case object Synthesis extends League
case object SynthesisHardcore extends League
case object Hardcore extends League
case object Standard extends League
