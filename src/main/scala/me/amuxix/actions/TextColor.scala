package me.amuxix.actions

import cats.Show
import cats.syntax.show._

/**
  * Created by Amuxix on 03/03/2017.
  */
case class TextColor(color: Color) extends AnyVal

object TextColor {
  implicit def show(implicit colorShow: Show[Color]): Show[TextColor] = textColor => show"SetTextColor ${textColor.color}"
}
