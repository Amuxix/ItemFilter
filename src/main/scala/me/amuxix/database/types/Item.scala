package me.amuxix.database.types

object Item extends Enumeration {
  type ItemType = Value
  val Amulet = Value("Amulet")
  val Belt = Value("Belt")
  val Quiver = Value("Quiver")
  val Ring = Value("Ring")
  val Talisman = Value("Talisman")
  val BodyArmour = Value("Body Armour")
  val Boots = Value("Boots")
  val Gloves = Value("Gloves")
  val Helmet = Value("Helmet")
  val LargeShield = Value("Large Shield")
  val MediumShield = Value("Medium Shield")
  val SmallShield = Value("Small Shield")
  val HybridFlask = Value("Hybrid Flask")
  val LifeFlask = Value("Life Flask")
  val ManaFlask = Value("Mana Flask")
  val UtilityFlask = Value("Utility Flask")
  val Jewel = Value("Jewel")
  val AbyssJewel = Value("Abyss Jewel")
  val Bow = Value("Bow")
  val Claw = Value("Claw")
  val Dagger = Value("Dagger")
  val RuneDaggers = Value("Rune Daggers")
  val OneHandAxe = Value("One Hand Axe")
  val OneHandMace = Value("One Hand Mace")
  val OneHandSword = Value("One Hand Sword")
  val Sceptre = Value("Sceptre")
  val Staff = Value("Staff")
  val Warstaves = Value("Warstaves")
  val ThrustingOneHandSword = Value("Thrusting One Hand Sword")
  val TwoHandAxe = Value("Two Hand Axe")
  val TwoHandMace = Value("Two Hand Mace")
  val TwoHandSword = Value("Two Hand Sword")
  val Wand = Value("Wand")
  val Piece = Value("Piece")
  val ClusterJewel = Value("Cluster Jewel")
}
