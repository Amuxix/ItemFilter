package me.amuxix.actions

import cats.Show

sealed case class CustomSound(soundLocation: String) extends Sound

object CustomSound {
  implicit val show: Show[CustomSound] = customSound => s"""CustomAlertSound "${customSound.soundLocation}.ogg""""
}
