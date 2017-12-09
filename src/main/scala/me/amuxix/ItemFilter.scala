package me.amuxix

import me.amuxix.categories._
import me.amuxix.categories.leagues._
import me.amuxix.categories.recipes._

object ItemFilter {
  def main(args: Array[String]): Unit = {
    val a = Seq(
      Myths, General, Gems, Essence, Talisman, Breach, Legacy, Harbinger, Currency, Maps,
      Uniques, Jewels, DivinationCards, Atlas, Chisel, Chromatic, Regal, Chaos, Flasks, LastCall
    ).map(_.writeCategory(Normal))
    println(a.mkString("", "\n", "\nHide"))
  }
}
