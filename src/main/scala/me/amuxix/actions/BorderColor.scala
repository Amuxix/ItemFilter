package me.amuxix.actions

import cats.Show
import cats.syntax.show._

/**
  * Created by Amuxix on 03/03/2017.
  */
case class BorderColor(color: Color) extends AnyVal

object BorderColor {
  implicit def show(implicit colorShow: Show[Color]): Show[BorderColor] = borderColour => show"SetBorderColor ${borderColour.color}"
}