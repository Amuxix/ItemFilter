package me.amuxix.categories.recipes

import me.amuxix.conditions.Condition

object Chromatic extends Sized {
  override def condition = Condition(socketGroup = "RGB")
}
