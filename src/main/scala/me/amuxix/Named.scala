package me.amuxix

/**
  * Created by Amuxix on 03/03/2017.
  */
trait Named {
  def name: String = {
    val spaced = getClass.getSimpleName
      .split("\\$")
      .last
      .replaceAll("([a-z])([A-Z])", "$1 $2")
    
    Named.replacements.foldLeft(spaced){
      case (string, fix) => string.replaceAll(s"(.\\s?)\\b$fix\\b", s"$$1${fix.toLowerCase}")
    }
  }
}

object Named {
  val replacements: Seq[String] = Seq(
    "Of",
    "The",
    "To",
    "At",
    "In",
    "And",
    "By",
    "Is",
    "That",
  )
}
