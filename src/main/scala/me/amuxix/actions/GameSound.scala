package me.amuxix.actions

import me.amuxix.InvalidArgument
import cats.Show
import cats.syntax.show._

/**
  * Created by Amuxix on 03/03/2017.
  */
sealed case class GameSound(soundNumber: Int, volume: Int) extends Sound {
  if (soundNumber < 0 || soundNumber > 16 || volume < 0 || volume > 300)
    throw new InvalidArgument

  def setVolume(volume: Int): GameSound = GameSound(this.soundNumber, volume)

  def quieter: GameSound = GameSound(this.soundNumber, (volume / 2).max(0))
  def louder: GameSound = GameSound(this.soundNumber, (volume * 2).min(300))
}

object GameSound {
  def apply(soundNumber: Int): GameSound = new GameSound(soundNumber, 100)

  implicit val show: Show[GameSound] = gameSound => show"PlayAlertSound ${gameSound.soundNumber} ${gameSound.volume}"
}
