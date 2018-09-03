package me.amuxix.actions

sealed case class CustomSound(soundLocation: String) extends Sound {
  override def print: String = s"""CustomAlertSound "$soundLocation.ogg""""
}
