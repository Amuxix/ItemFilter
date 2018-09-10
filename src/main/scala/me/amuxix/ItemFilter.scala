package me.amuxix

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import play.api.libs.ws._
import play.api.libs.ws.ahc._
import java.io.{File, PrintWriter}
import java.util.concurrent.TimeUnit

import com.github.benmanes.caffeine.cache.{Caffeine, Ticker}
import javax.swing.filechooser.FileSystemView
import me.amuxix.categories._
import me.amuxix.categories.leagues._
import me.amuxix.categories.recipes._
import me.amuxix.items.Item
import me.amuxix.providers.poeninja.PoeNinja
import play.api.libs.ws.ahc.cache.{AhcHttpCache, Cache, EffectiveURIKey, ResponseEntry}
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

object ItemFilter {
  def wsClient(): (ActorSystem, StandaloneAhcWSClient) = {
    // Create Akka system for thread and streaming management
    implicit val system = ActorSystem()
    system.registerOnTermination {
      System.exit(0)
    }
    implicit val materializer = ActorMaterializer()

    // Create the standalone WS client
    // no argument defaults to a AhcWSClientConfig created from
    // "AhcWSClientConfigFactory.forConfig(ConfigFactory.load, this.getClass.getClassLoader)"
    (system, StandaloneAhcWSClient())
  }

  def main(args: Array[String]): Unit = {
    /*val poeFolder = FileSystemView.getFileSystemView.getDefaultDirectory.getPath + File.separatorChar + "My Games" + File.separatorChar + "Path of Exile" + File.separatorChar
    //val poeFolder = new java.io.File(".").getCanonicalPath

    val categories: Seq[Category] = Seq(
      Myths,
      General,
      Gems,
      Essence,
      Talisman,
      Beastiary,
      Abyss,
      Breach,
      Legacy,
      Harbinger,
      Incursion,
      Delve,
      Currency,
      Maps,
      Uniques,
      Jewels,
      DivinationCards,
      ShaperAndElder,
      BestBases,
      Atlas,
      Leveling,
      Chisel,
      Regal,
      Chaos,
      Chromatic,
      TwentyQuality,
      Flasks
    )
    //println(currentDirectory.toString)
    Seq(Reduced, Normal, Racing).foreach(createFilterFile(poeFolder, _, categories))
    createFilterFile(poeFolder, Reduced, categories, conceal = true)*/
    val (system, client) = wsClient()
    implicit val provider = new PoeNinja(client)
    Future
      .sequence(Item.items.map(_.block(Normal, 0.1)))
      .map(Mergeable.merge(_).map(_.write).mkString)
      .map(println)
      .andThen { case _ => client.close() }
      .andThen { case _ => system.terminate() }
    println("Done")
  }

  def createFilterFile(poeFolder: String, filterLevel: FilterLevel, categories: Seq[Category], conceal: Boolean = false): Unit = {
    val filterFile = new PrintWriter(new File(poeFolder + s"${if (conceal) "Concealed " else ""}Amuxix's${filterLevel.suffix} filter.filter"))
    val (shown, hidden) = categories.map(_.partitionHiddenAndShown(filterLevel, conceal)).unzip
    filterFile.write((shown ++ hidden ++ LastCall.write).mkString)
    filterFile.close()
  }
}
