package me.amuxix.actions

import me.amuxix.Writable

/**
  * Created by Amuxix on 03/03/2017.
  */
case class Action(size: Size = Size.default,
                  sound: Sound = Sound.default,
                  border: Border = Border.default,
                  background: Background = Background.default,
                  text: Text = Text.default) {
  val actions: Seq[Writable] = Seq(size, sound, border, background, text)
}
