package me.amuxix

import me.amuxix.categories._
import me.amuxix.categories.leagues._
import me.amuxix.categories.recipes.{Chisel, Chromatic}

object ItemFilter {
  def main(args: Array[String]): Unit = {
    val a = Seq(
      Myths, General, Gems, Essence, Talisman, Breach, Legacy, Harbinger, Currency, Maps,
      Uniques, Jewels, DivinationCards, Atlas, Chisel, Chromatic, Flasks, LastCall
    ).map(_.writeCategory(Normal))
    println(a.mkString("", "\n", "\nHide"))
  }
}
