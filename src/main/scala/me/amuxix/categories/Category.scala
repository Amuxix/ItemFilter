package me.amuxix.categories

import me.amuxix._

abstract class Category extends ImplicitConversions with Named {
  protected def categoryBlocks(filterLevel: FilterLevel): Seq[Block]
  def writeCategory(filterLevel: FilterLevel): String = {
    separator + Mergeable.merge(categoryBlocks(filterLevel)).map(_.write).mkString("\n")
  }

  private def separator(): String = {
    val asterics = "*"  * (59 - name.length / 2)
    s"#$asterics $name $asterics\n"
  }
}
