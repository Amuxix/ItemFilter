package me.amuxix.conditions

import me.amuxix.Named

/**
  * Created by Amuxix on 03/03/2017.
  */
sealed trait Classes extends BaseCondition with Named
class Flasks extends Classes
object LifeFlasks extends Flasks
object ManaFlasks extends Flasks
object HybridFlasks extends Flasks
object UtilityFlasks extends Flasks
object CriticalUtilityFlasks extends Flasks

class Currency extends Classes
object StackableCurrency extends Currency

class SkillGems extends Classes
object ActiveSkillGems extends SkillGems
object SupportSkillGems extends SkillGems

trait Swords extends Classes
trait Axes extends Classes
trait Maces extends Classes

class OneHand extends Classes
object OneHandSwords extends OneHand with Swords
object ThrustingOneHandSwords extends OneHand with Swords
object OneHandAxes extends OneHand with Axes
object OneHandMaces extends OneHand with Maces
class TwoHand extends Classes
object TwoHandSwords extends TwoHand with Swords
object TwoHandAxes extends TwoHand with Axes
object TwoHandMaces extends TwoHand with Maces

object Claws extends Classes
object Daggers extends Classes
object Wands extends Classes
object Bows extends Classes
object Staves extends Classes
object Quivers extends Classes
object Gloves extends Classes
object Boots extends Classes
object BodyArmours extends Classes
object Helmets extends Classes
object Shields extends Classes

object Amulets extends Classes
object Rings extends Classes
object Belts extends Classes

class Relics
object SmallRelics extends Relics
object MediumRelics extends Relics
object LargeRelics extends Relics

object QuestItems extends Classes
object Sceptres extends Classes
object Unarmed extends Classes
object FishingRods extends Classes
class Map extends Classes
object Maps extends Map
object MapFragments extends Map
object MiscMapItems extends Map
object HideoutDoodads extends Classes
object Microtransactions extends Classes
object Jewel extends Classes
object DivinationCard extends Classes
class Labyrinth extends Classes
object LabyrinthItem extends Labyrinth
object LabyrinthTrinket extends Labyrinth
object LabyrinthMapItem extends Labyrinth
object Leaguestone extends Classes
