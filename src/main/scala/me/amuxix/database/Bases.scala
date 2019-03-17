package me.amuxix.database

import cats.data.NonEmptyList
import me.amuxix.ItemFilter.ec
import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.{Base, BestBaseBlocks}

import scala.concurrent.Future

class BasesTable(tag: Tag) extends Table[Base](tag, "bases") with CommonColumns[Base] {
  def height = column[Int]("height")
  def width = column[Int]("width")
  def dropLevel = column[Int]("drop_level")
  def `class` = column[String]("class")

  override def * = (
    name,
    height,
    width,
    dropLevel,
    `class`,
    dropEnabled,
  ).mapTo[Base]
}

object Bases extends BasicOperations[Base, BasesTable](new BasesTable(_)) {

  private def getByClass(`class`: String)(implicit ev: BasesTable#TableElementType =:= Base): Future[NonEmptyList[Base]] =
    db.run(filter(_.`class` === `class`).sortBy(_.dropLevel).result).map {
      case Seq() =>
        println(s"Found 0 bases of ${`class`}")
        throw new MatchError(s"Found 0 bases of ${`class`}")
      case Seq(head, tail @ _*) => NonEmptyList(head, tail.toList)
    }

  private def getByClassWithBestBases(`class`: String, bestModsLevel: Int = 84): Future[NonEmptyList[Base with BestBaseBlocks]] =
    getByClass(`class`).map(_.map(_.withBestBaseBlocks(bestModsLevel)))

  lazy val flasks: Future[NonEmptyList[Base]] = {
    val life = getByClass("Life Flasks")
    val mana = getByClass("Mana Flasks")
    val hybrid = getByClass("Hybrid Flasks")
    for {
      lifeFlasks <- life
      manaFlasks <- mana
      hybridFlasks <- hybrid
    } yield lifeFlasks.concatNel(manaFlasks).concatNel(hybridFlasks)
  }

  lazy val rings: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Ring")

  lazy val amulets: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Amulet")

  lazy val belts: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Belt")

  lazy val bodyArmours: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Body Armour")

  lazy val helmets: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Helmet")

  lazy val gloves: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Gloves")

  lazy val boots: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Boots")

  lazy val oneHandedAxes: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("One Handed Axe", 83)
  lazy val twoHandedAxes: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Two Handed Axe", 83)
  lazy val bows: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Bow", 83)
  lazy val claws: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Claw", 83)
  lazy val daggers: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Dagger", 83)
  lazy val oneHandedMaces: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("One Handed Mace", 83)
  lazy val sceptres: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Sceptre", 83)
  lazy val staffs: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Staff", 83)
  lazy val oneHandedSwords: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("One Handed Sword", 83)
  lazy val twoHandedSwords: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Two Handed Sword", 83)
  lazy val thrustingOneHandedSwords: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Thrusting One Handed Sword", 83)
  lazy val wands: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Wand", 83)
}
