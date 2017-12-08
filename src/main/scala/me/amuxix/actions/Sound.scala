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
  val epic = Sound(8, 200)
  val rare = Sound(6, 200)
  val sixLinks = Sound(9, 300)
  val gems = Sound(4, 100)
  val t2Currency = Sound(10, 100)
  val t3Currency: Sound = rare.quieter
  val pieces = Sound(8, 100)

}
sealed case class Sound(soundNumber: Int, volume: Int) extends Writable {
  def this(soundNumber: Int) = this(soundNumber, 100)
  if (soundNumber < 0 || soundNumber > 9 || volume < 0 || volume > 300) throw new InvalidArgument

  def setVolume(volume: Int): Sound = Sound(this.soundNumber, volume)

  def quieter:Sound = Sound(this.soundNumber, volume - 100 max 0)
  def louder:Sound = Sound(this.soundNumber, volume + 100 min 300)

  override def print: String = s"PlayAlertSound $soundNumber $volume"
}
