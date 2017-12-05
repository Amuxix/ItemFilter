package me.amuxix.actions

import me.amuxix.{Default, InvalidArgument, RefEquals}

/**
  * Created by Amuxix on 03/03/2017.
  */
object Sound extends Default[Sound] {
  override val default = new Sound(0)
  implicit def int2Size(size: Int): Sound = new Sound(size)
  implicit def tuple22Size(tuple: (Int, Int)): Sound = Sound(tuple._1, tuple._2)
  def apply(soundNumber: Int): Sound = new Sound(soundNumber)
}
case class Sound(soundNumber: Int, volume: Int) extends BaseAction with RefEquals {
  def this(soundNumber: Int) = this(soundNumber, 100)
  if (soundNumber < 0 || soundNumber > 9 || volume < 0 || volume > 300) throw new InvalidArgument

  override def print: String = s"PlayAlertSound $soundNumber $volume"
}
