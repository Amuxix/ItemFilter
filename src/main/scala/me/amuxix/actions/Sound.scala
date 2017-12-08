package me.amuxix.actions

import me.amuxix.{InvalidArgument, Writable}

/**
  * Created by Amuxix on 03/03/2017.
  */
object Sound {
  implicit def int2Sound(sound: Int): Sound = new Sound(sound)
  implicit def tuple22Sound(tuple: (Int, Int)): Sound = Sound(tuple._1, tuple._2)

  def apply(soundNumber: Int): Sound = new Sound(soundNumber)

  val myths = Sound(5, 300)
  val sixLinks = Sound(9, 300)
  val gems = Sound(4, 100)

}
sealed case class Sound(soundNumber: Int, volume: Int) extends Writable {
  def this(soundNumber: Int) = this(soundNumber, 100)
  if (soundNumber < 0 || soundNumber > 9 || volume < 0 || volume > 300) throw new InvalidArgument

  override def print: String = s"PlayAlertSound $soundNumber $volume"
}
