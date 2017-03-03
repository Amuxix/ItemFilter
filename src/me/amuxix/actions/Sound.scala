package me.amuxix.actions

import com.sun.javaws.exceptions.InvalidArgumentException

/**
  * Created by Amuxix on 03/03/2017.
  */
object Sound {
  def apply(soundNumber: Int): Sound = new Sound(soundNumber)
}
case class Sound(soundNumber: Int, volume: Int) extends BaseAction {
  def this(soundNumber: Int) = this(soundNumber, 100)
  if (soundNumber < 0 || soundNumber > 9 || volume < 0 || volume > 300) throw InvalidArgumentException

  override def toString: String = s"PlayAlertSound $soundNumber $volume"
}
