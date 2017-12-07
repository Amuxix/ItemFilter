package me.amuxix.actions

import me.amuxix.Writable

/**
  * Created by Amuxix on 03/03/2017.
  */
case class Action(size: Option[Size] = Some(Size.default),
                  sound: Option[Sound] = None,
                  border: Option[Border] = None,
                  background: Option[Background] = None,
                  text: Option[Text] = None) {
  val actions: Seq[Writable] = Seq(size, sound, border, background, text).collect{ case Some(writable) => writable}
}