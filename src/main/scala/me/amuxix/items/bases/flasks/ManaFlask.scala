package me.amuxix.items.bases.flasks
import me.amuxix.items.bases.Flask

case class ManaFlask(
  name: String,
  dropLevel: Int,
  dropEnabled: Boolean,
  implicits: List[String] = List.empty,
  prefixes: List[String] = List.empty,
  suffixes: List[String] = List.empty,
  quality: Option[Int] = None,
) extends Flask {

}
