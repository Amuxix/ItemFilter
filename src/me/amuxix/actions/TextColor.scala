package me.amuxix.actions

/**
  * Created by Amuxix on 03/03/2017.
  */
case class TextColor(color: Color) extends BaseAction {
  override def toString: String = "SetTextColor" + super.toString
}
