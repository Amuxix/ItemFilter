package me.amuxix.actions

/**
  * Created by Amuxix on 03/03/2017.
  */
case class BackgroundColor(color: Color) extends BaseAction {
  override def toString: String = "SetBackgroundColor" + super.toString
}
