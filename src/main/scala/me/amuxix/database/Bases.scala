package me.amuxix.database

import me.amuxix.database.PostgresProfile.api._
import me.amuxix.items.{Base, BestBaseBlocks}

import scala.concurrent.Future

class BasesTable(tag: Tag) extends Table[Base](tag, "bases") with NamedTable[Base] {
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
  ) <> ((Base.apply _).tupled, Base.unapply)
}

object Bases extends BasicOperations[Base, BasesTable](new BasesTable(_)) {

  private def getByClass(`class`: String)(implicit ev: BasesTable#TableElementType =:= Base) : Future[Seq[Base]] =
    db.run(filter(_.`class` === `class`).sortBy(_.dropLevel).result)

  private def getByClassWithBestBases(`class`: String, bestModsLevel: Int = 84): Future[Seq[Base with BestBaseBlocks]] =
    getByClass(`class`).map(_.map(_.withBestBaseBlocks(bestModsLevel)))

  def flasks: Future[Seq[Base]] = for {
    lifeFlasks <- getByClass("Life Flasks")
    manaFlasks <- getByClass("Mana Flasks")
    hybridFlasks <- getByClass("Hybrid Flasks")
  } yield lifeFlasks ++ manaFlasks ++ hybridFlasks
  
  def rings: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Ring")
  
  def amulets: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Amulet")
  
  def belts: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Belts")
  
  def bodyArmours: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Body Armour")
  
  def helmets: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Helmet")
  
  def gloves: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Gloves")
  
  def boots: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Boots")

  def oneHandedAxes: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("One Handed Axe", 83)
  def twoHandedAxes: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Two Handed Axe", 83)
  def bows: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Bow", 83)
  def claws: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Claw", 83)
  def daggers: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Dagger", 83)
  def oneHandedMaces: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("One Handed Mace", 83)
  def sceptres: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Sceptre", 83)
  def staffs: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Staff", 83)
  def oneHandedSwords: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("One Handed Sword", 83)
  def twoHandedSwords: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Two Handed Sword", 83)
  def thrustingOneHandedSwords: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Thrusting One Handed Sword", 83)
  def wands: Future[Seq[Base with BestBaseBlocks]] = getByClassWithBestBases("Wand", 83)
}
