package me.amuxix.items

case class DivinationCard(name: String, dropEnabled: Boolean) extends Item with Dimensions with Stackable with ProviderPrice {
  override val dropLevel: Int = 1
  override val stackSize: Int = 1
  override val height: Int = 1
  override val width: Int = 1
  override val `class`: String = "Divination Card"
}
