package me.amuxix.actions

import me.amuxix.InvalidArgument

/**
  * Created by Amuxix on 03/03/2017.
  */
object GameSound {
  def apply(soundNumber: Int): GameSound = new GameSound(soundNumber, 100)
}

sealed case class GameSound(soundNumber: Int, volume: Int) extends Sound {
  if (soundNumber < 0 || soundNumber > 16 || volume < 0 || volume > 300)
    throw new InvalidArgument

  def setVolume(volume: Int): GameSound = GameSound(this.soundNumber, volume)

  def quieter: GameSound = GameSound(this.soundNumber, (volume / 2).max(0))
  def louder: GameSound = GameSound(this.soundNumber, (volume * 2).min(300))

  override def print: String = s"PlayAlertSound $soundNumber $volume"
}
