package me.amuxix.actions

/**
  * Created by Amuxix on 03/03/2017.
  */
case class Action(actions: Seq[BaseAction]) {
  override def toString: String = actions.map(_.toString).mkString( "\n")
}
