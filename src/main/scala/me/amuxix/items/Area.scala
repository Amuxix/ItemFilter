package me.amuxix.items

import me.amuxix.providers.Provider

trait Area {
  def area(provider: Provider): Option[Int]
}
