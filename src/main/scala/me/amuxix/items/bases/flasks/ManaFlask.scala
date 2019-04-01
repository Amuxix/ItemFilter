package me.amuxix.items.bases.flasks
import me.amuxix.items.bases.Flask
import me.amuxix.items.Variant.Variation

case class ManaFlask(
  name: String,
  dropLevel: Int,
  dropEnabled: Boolean,
  implicits: List[String] = List.empty,
  prefixes: List[String] = List.empty,
  suffixes: List[String] = List.empty,
  quality: Option[Int] = None,
  variant: Option[Variation] = None,
) extends Flask {

}
