package me.amuxix.actions

object CustomSound {
  val myths = CustomSound("Myths")
  val epic = CustomSound("Epic")
  val rare = CustomSound("Rare")
  val sixLinks = CustomSound("Six Links")
  val gems = CustomSound("Gems")
  val t2Currency = CustomSound("t2Currency")
  val t3Currency = CustomSound("t3Currency")
  val pieces = CustomSound("Pieces")
  val maps = CustomSound("Maps")
  val divCards = CustomSound("Div Cards")
  val scrolls = CustomSound("Scrolls")
}

sealed case class CustomSound(soundLocation: String) extends Sound {
  override def print: String = s"""CustomAlertSound "$soundLocation.ogg""""
}
