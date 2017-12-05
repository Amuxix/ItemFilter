package me.amuxix

sealed abstract class FilterLevel(prefix: String)

object Leveling extends FilterLevel("Leveling")
object Reduced extends FilterLevel("Reduced")
object Normal extends FilterLevel("")