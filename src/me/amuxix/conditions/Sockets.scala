package me.amuxix.conditions

import com.sun.javaws.exceptions.InvalidArgumentException

/**
  * Created by Amuxix on 03/03/2017.
  */
case class Sockets(s: Int) {
  if (s < 0 || s > 6) throw InvalidArgumentException
}
