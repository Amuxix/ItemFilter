package me.amuxix.actions

import cats.Show
import me.amuxix.actions.Color.defaultBackground
import me.amuxix.syntax.contravariantShow._
import me.amuxix.instances.option._

/**
  * Created by Amuxix on 03/03/2017.
  */
case class Action(
  size: Option[Size] = Some(Size.default),
  sound: Option[Sound] = None,
  borderColor: Option[BorderColor] = None,
  backgroundColor: Option[BackgroundColor] = Some(BackgroundColor(defaultBackground)),
  textColor: Option[TextColor] = None,
  beam: Option[Beam] = None,
  minimapIcon: Option[MinimapIcon] = None
)

object Action {
  implicit val show: Show[Action] = (action: Action) => Seq(
    action.size.show,
    action.sound.show,
    action.borderColor.show,
    action.backgroundColor.show,
    action.textColor.show,
    action.beam.show,
    action.minimapIcon.show,
  ).filter(_.nonEmpty).mkString("\n  ", "\n  ", "")
}
