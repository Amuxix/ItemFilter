package me.amuxix.categories

import me.amuxix.FilterLevel

abstract class Category {
  def createCategory(filterLevel: FilterLevel): Unit
}
