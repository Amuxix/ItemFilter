package me.amuxix.database.types

object Currency extends Enumeration {
  type CurrencyType = Value
  val Net = Value("Net")
  val Orb = Value("Orb")
  val Vial = Value("Vial")
  val Fossil = Value("Fossil")
  val Oil = Value("Oil")
  val Catalyst = Value("Catalyst")
  val DeliriumOrb = Value("Delirium Orb")
  val HarbingerScroll = Value("Harbinger Scroll")
}
