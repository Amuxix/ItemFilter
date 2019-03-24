package me.amuxix.items.bases
import me.amuxix.items.Base

case class Piece(
  name: String,
  dropEnabled: Boolean,
) extends Base {
  override val dropLevel: Int = 1
  override val height: Int = 1
  override val width: Int = 1
}
