package me.amuxix.items

case class ItemSize(height: Int, width: Int) {
  val area: Int = height * width
}
