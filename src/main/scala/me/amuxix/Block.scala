package me.amuxix

import me.amuxix.actions._
import me.amuxix.conditions.Condition

object Block {
  def apply(condition: Condition, action: Action): Block = new Block(condition, action, true)
  def apply(condition: Condition): Block = new Block(condition, Action(), true)
}

case class Block(condition: Condition, action: Action, show: Boolean) extends Mergeable[Block] {
  val write: String = {
    val showText = if (show) "Show" else "Hide"
    val actionsAndConditions = ((condition.conditions ++ action.actions).flatMap(_.write) :+ "DisableDropSound").mkString("\n  ", "\n  ", "\n")
    showText + actionsAndConditions
  }

  def hidden: Block = Block(
    condition,
    action.copy(sound = None, minimapIcon = None, beam = None),
    show = false
  )

  private def averageColor: Color =
    (action.backgroundColor.map(_.color), action.textColor.map(_.color), action.borderColor.map(_.color)) match {
      case (None, None, None)                         => Color.white
      case (Some(background), _, _)                   => background
      case (None, Some(textColor), Some(borderColor)) => Color.average(Seq(textColor, borderColor))
      case (None, Some(textColor), None)              => textColor
      case (None, None, Some(borderColor))            => borderColor
    }

  def concealed(conceal: Boolean): Block = {
    if (conceal == false) return this
    val concealedAction = if (show) {
      action.copy(
        beam = Some(action.beam.getOrElse(Beam(averageColor.closestEffectColor, isTemp = true))),
        minimapIcon = Some(action.minimapIcon.getOrElse(MinimapIcon(averageColor.closestEffectColor, Circle)))
      )
    } else {
      action.copy(
        size = Some(action.size.fold(Size(Size.default))(identity).change(-10)),
        /*backgroundColor = action.backgroundColor.map(c => c.copy(c.color.halfTransparent)),
        textColor = action.textColor.map(c => c.copy(c.color.halfTransparent)),
        borderColor = action.borderColor.map(c => c.copy(c.color.halfTransparent))*/
      )
    }
    Block(condition, concealedAction, show = false)
  }

  override def canMerge(other: Block): Boolean =
    action == other.action && show == other.show && (condition canMerge other.condition)

  override def merge(other: Block) = Block(condition merge other.condition, action, show)
}
