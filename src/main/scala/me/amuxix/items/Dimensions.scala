package me.amuxix.items

import me.amuxix.providers.Provider

trait Dimensions extends Area {
  val height: Int
  val width: Int
  override def area(provider: Provider): Option[Int] = Some(height * width)
}
