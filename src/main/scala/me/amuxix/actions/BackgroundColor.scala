package me.amuxix.actions

import cats.Show
import cats.syntax.show._

/**
  * Created by Amuxix on 03/03/2017.
  */
case class BackgroundColor(color: Color) extends AnyVal

object BackgroundColor {
  implicit def show(implicit colorShow: Show[Color]): Show[BackgroundColor] = backgroundColour => show"SetBackgroundColor ${backgroundColour.color}"
}
