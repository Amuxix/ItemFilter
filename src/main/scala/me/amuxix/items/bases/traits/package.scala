package me.amuxix.items.bases

package object traits {
  trait HasQuality
  trait Corruptible
  trait Elder
  trait Shaper
  trait Level {
    val level: Int
  }
  trait HasSockets
  trait HasRarity
}
