package me.amuxix.actions

import me.amuxix.Writable
import me.amuxix.actions.Color.defaultBackground

/**
  * Created by Amuxix on 03/03/2017.
  */
case class Action(
  size: Option[Size] = Some(Size.default),
  sound: Option[Sound] = None,
  borderColor: Option[BorderColor] = None,
  backgroundColor: Option[BackgroundColor] = Some(defaultBackground),
  textColor: Option[TextColor] = None,
  beam: Option[Beam] = None,
  minimapIcon: Option[MinimapIcon] = None
) {
  val actions: Seq[Writable] = Seq(size, sound, borderColor, backgroundColor, textColor, beam, minimapIcon).flatten
}
