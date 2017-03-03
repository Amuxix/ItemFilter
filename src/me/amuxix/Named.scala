package me.amuxix

/**
  * Created by Amuxix on 03/03/2017.
  */
trait Named {
  val name: String = getClass.getSimpleName.split("\\$").last.replaceAll("([a-z])([A-Z])", "$1 $2")
}
