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
      case Seq() => throw new MatchError(s"Found 0 bases of ${`class`}")
      case Seq(head, tail @ _*) => NonEmptyList(head, tail.toList)
    }

  private def getByClassWithBestBases(`class`: String, bestModsLevel: Int = 84): Future[NonEmptyList[Base with BestBaseBlocks]] =
    getByClass(`class`).map(_.map(_.withBestBaseBlocks(bestModsLevel)))

  def flasks: Future[NonEmptyList[Base]] = for {
    lifeFlasks <- getByClass("Life Flasks")
    manaFlasks <- getByClass("Mana Flasks")
    hybridFlasks <- getByClass("Hybrid Flasks")
  } yield lifeFlasks.concatNel(manaFlasks).concatNel(hybridFlasks)

  def rings: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Ring")

  def amulets: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Amulet")

  def belts: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Belt")

  def bodyArmours: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Body Armour")

  def helmets: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Helmet")

  def gloves: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Gloves")

  def boots: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Boots")

  def oneHandedAxes: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("One Handed Axe", 83)
  def twoHandedAxes: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Two Handed Axe", 83)
  def bows: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Bow", 83)
  def claws: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Claw", 83)
  def daggers: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Dagger", 83)
  def oneHandedMaces: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("One Handed Mace", 83)
  def sceptres: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Sceptre", 83)
  def staffs: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Staff", 83)
  def oneHandedSwords: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("One Handed Sword", 83)
  def twoHandedSwords: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Two Handed Sword", 83)
  def thrustingOneHandedSwords: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Thrusting One Handed Sword", 83)
  def wands: Future[NonEmptyList[Base with BestBaseBlocks]] = getByClassWithBestBases("Wand", 83)
}
