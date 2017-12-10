package me.amuxix

sealed abstract case class FilterLevel(suffix: String)

object Racing extends FilterLevel("Leveling")
object Reduced extends FilterLevel("Reduced")
object Normal extends FilterLevel("")