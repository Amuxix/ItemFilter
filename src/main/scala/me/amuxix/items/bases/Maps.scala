package me.amuxix.items.bases
import me.amuxix.Named
import me.amuxix.conditions.Condition
import me.amuxix.items.FilterClass

object Map extends FilterClass[Map] {
  def dropLevel(tier: Int): Int = tier match {
    case 1 => 58
    case _ => 68 + tier
  }

  override val all: Seq[Map] = Seq(
    FloodedMineMap,
    ChannelMap,
    AtollMap,
    RampartsMap,
    DungeonMap,
    PenMap,
    AridLakeMap,
    IcebergMap,
    ThicketMap,
    ArmouryMap,
    GraveyardMap,
    DesertMap,
    CageMap,
    FungalHollowMap,
    ExcavationMap,
    PeninsulaMap,
    GrottoMap,
    ShipyardMap,
    BoneCryptMap,
    CursedCryptMap,
    GlacierMap,
    StrandMap,
    LookoutMap,
    SpiderLairMap,
    BarrowsMap,
    BeachMap,
    MarshesMap,
    LighthouseMap,
    CraterMap,
    CourtyardMap,
    PortMap,
    AlleywaysMap,
    MazeMap,
    MausoleumMap,
    ResidenceMap,
    CitySquareMap,
    JungleValleyMap,
    UndergroundSeaMap,
    GardensMap,
    VaalPyramidMap,
    PhantasmagoriaMap,
    AcademyMap,
    VolcanoMap,
    CanyonMap,
    FieldsMap,
    WharfMap,
    AshenWoodMap,
    SulphurVentsMap,
    PrecinctMap,
    HauntedMansionMap,
    TempleMap,
    CellsMap,
    ArcadeMap,
    ConservatoryMap,
    ToxicSewerMap,
    GhettoMap,
    LavaChamberMap,
    DunesMap,
    UndergroundRiverMap,
    PrimordialPoolMap,
    BazaarMap,
    GeodeMap,
    MudGeyserMap,
    ShoreMap,
    LaboratoryMap,
    InfestedValleyMap,
    SepulchreMap,
    WastelandMap,
    OrchardMap,
    PromenadeMap,
    ArachnidNestMap,
    OvergrownRuinMap,
    MineralPoolsMap,
    MoonTempleMap,
    RelicChambersMap,
    TropicalIslandMap,
    WastePoolMap,
    VaultMap,
    ArenaMap,
    MuseumMap,
    ScriptoriumMap,
    AncientCityMap,
    WaterwaysMap,
    CemeteryMap,
    CoralRuinsMap,
    LeylineMap,
    PlateauMap,
    EstuaryMap,
    BelfryMap,
    PierMap,
    SpiderForestMap,
    CovesMap,
    PlazaMap,
    PitMap,
    SiegeMap,
    ArachnidTombMap,
    CrystalOreMap,
    ParkMap,
    BogMap,
    LairMap,
    FactoryMap,
    MesaMap,
    BurialChambersMap,
    ChateauMap,
    IvoryTempleMap,
    ColonnadeMap,
    ArsenalMap,
    DefiledCathedralMap,
    OvergrownShrineMap,
    CastleRuinsMap,
    VillaMap,
    NecropolisMap,
    MalformationMap,
    CalderaMap,
    ReefMap,
    RacecourseMap,
    CrimsonTempleMap,
    DigMap,
    CoreMap,
    ColosseumMap,
    AcidCavernsMap,
    ShrineMap,
    CourthouseMap,
    TerraceMap,
    DarkForestMap,
    PalaceMap,
    BasilicaMap,
    SunkenCityMap,
    CarcassMap,
    TowerMap,
    SummitMap,
    PrimordialBlocksMap,
    DesertSpringMap,
    LavaLakeMap,
    ForgeOfThePhoenixMap,
    LairOfTheHydraMap,
    MazeOfTheMinotaurMap,
    PitOfTheChimeraMap,
  )

  lazy val tier1 = all.filter(_.tier == 1)
  lazy val tier2 = all.filter(_.tier == 2)
  lazy val tier3 = all.filter(_.tier == 3)
  lazy val tier4 = all.filter(_.tier == 4)
  lazy val tier5 = all.filter(_.tier == 5)
  lazy val tier6 = all.filter(_.tier == 6)
  lazy val tier7 = all.filter(_.tier == 7)
  lazy val tier8 = all.filter(_.tier == 8)
  lazy val tier9 = all.filter(_.tier == 9)
  lazy val tier10 = all.filter(_.tier == 10)
  lazy val tier11 = all.filter(_.tier == 11)
  lazy val tier12 = all.filter(_.tier == 12)
  lazy val tier13 = all.filter(_.tier == 13)
  lazy val tier14 = all.filter(_.tier == 14)
  lazy val tier15 = all.filter(_.tier == 15)
  lazy val tier16 = all.filter(_.tier == 16)

  lazy val white = all.filter(_.tier < 6)
  lazy val yellow = all.filter(m => m.tier >= 6 && m.tier < 11)
  lazy val red = all.filter(m => m.tier >= 11)
}

sealed abstract class Map(val tier: Int) extends Base(1, 1, Map.dropLevel(tier), "Maps") with Named {
  private val mapLevel = 67 + tier
  def sameTierOrUpgrade: Condition = condition.copy(itemLevel = mapLevel)
  def good: Condition = condition.copy(itemLevel = (mapLevel - (tier / 3) - 1, mapLevel - 1))
}

case object FloodedMineMap extends Map(tier = 1)
case object ChannelMap extends Map(tier = 1)
case object AtollMap extends Map(tier = 1)
case object RampartsMap extends Map(tier = 1)
case object DungeonMap extends Map(tier = 2)
case object PenMap extends Map(tier = 2)
case object AridLakeMap extends Map(tier = 2)
case object IcebergMap extends Map(tier = 2)
case object ThicketMap extends Map(tier = 2)
case object ArmouryMap extends Map(tier = 2)
case object GraveyardMap extends Map(tier = 3)
case object DesertMap extends Map(tier = 3)
case object CageMap extends Map(tier = 3)
case object FungalHollowMap extends Map(tier = 3)
case object ExcavationMap extends Map(tier = 3)
case object PeninsulaMap extends Map(tier = 3)
case object GrottoMap extends Map(tier = 3)
case object ShipyardMap extends Map(tier = 3)
case object BoneCryptMap extends Map(tier = 3)
case object CursedCryptMap extends Map(tier = 3)
case object GlacierMap extends Map(tier = 4)
case object StrandMap extends Map(tier = 4)
case object LookoutMap extends Map(tier = 4)
case object SpiderLairMap extends Map(tier = 4)
case object BarrowsMap extends Map(tier = 4)
case object BeachMap extends Map(tier = 4)
case object MarshesMap extends Map(tier = 4)
case object LighthouseMap extends Map(tier = 4)
case object CraterMap extends Map(tier = 4)
case object CourtyardMap extends Map(tier = 4)
case object PortMap extends Map(tier = 5)
case object AlleywaysMap extends Map(tier = 5)
case object MazeMap extends Map(tier = 5)
case object MausoleumMap extends Map(tier = 5)
case object ResidenceMap extends Map(tier = 5)
case object CitySquareMap extends Map(tier = 5)
case object JungleValleyMap extends Map(tier = 5)
case object UndergroundSeaMap extends Map(tier = 5)
case object GardensMap extends Map(tier = 5)
case object VaalPyramidMap extends Map(tier = 5)
case object PhantasmagoriaMap extends Map(tier = 6)
case object AcademyMap extends Map(tier = 6)
case object VolcanoMap extends Map(tier = 6)
case object CanyonMap extends Map(tier = 6)
case object FieldsMap extends Map(tier = 6)
case object WharfMap extends Map(tier = 6)
case object AshenWoodMap extends Map(tier = 6)
case object SulphurVentsMap extends Map(tier = 6)
case object PrecinctMap extends Map(tier = 6)
case object HauntedMansionMap extends Map(tier = 6)
case object TempleMap extends Map(tier = 6)
case object CellsMap extends Map(tier = 7)
case object ArcadeMap extends Map(tier = 7)
case object ConservatoryMap extends Map(tier = 7)
case object ToxicSewerMap extends Map(tier = 7)
case object GhettoMap extends Map(tier = 7)
case object LavaChamberMap extends Map(tier = 7)
case object DunesMap extends Map(tier = 7)
case object UndergroundRiverMap extends Map(tier = 7)
case object PrimordialPoolMap extends Map(tier = 7)
case object BazaarMap extends Map(tier = 7)
case object GeodeMap extends Map(tier = 7)
case object MudGeyserMap extends Map(tier = 8)
case object ShoreMap extends Map(tier = 8)
case object LaboratoryMap extends Map(tier = 8)
case object InfestedValleyMap extends Map(tier = 8)
case object SepulchreMap extends Map(tier = 8)
case object WastelandMap extends Map(tier = 8)
case object OrchardMap extends Map(tier = 8)
case object PromenadeMap extends Map(tier = 8)
case object ArachnidNestMap extends Map(tier = 8)
case object OvergrownRuinMap extends Map(tier = 8)
case object MineralPoolsMap extends Map(tier = 8)
case object MoonTempleMap extends Map(tier = 9)
case object RelicChambersMap extends Map(tier = 9)
case object TropicalIslandMap extends Map(tier = 9)
case object WastePoolMap extends Map(tier = 9)
case object VaultMap extends Map(tier = 9)
case object ArenaMap extends Map(tier = 9)
case object MuseumMap extends Map(tier = 9)
case object ScriptoriumMap extends Map(tier = 9)
case object AncientCityMap extends Map(tier = 9)
case object WaterwaysMap extends Map(tier = 9)
case object CemeteryMap extends Map(tier = 9)
case object CoralRuinsMap extends Map(tier = 10)
case object LeylineMap extends Map(tier = 10)
case object PlateauMap extends Map(tier = 10)
case object EstuaryMap extends Map(tier = 10)
case object BelfryMap extends Map(tier = 10)
case object PierMap extends Map(tier = 10)
case object SpiderForestMap extends Map(tier = 10)
case object CovesMap extends Map(tier = 10)
case object PlazaMap extends Map(tier = 10)
case object PitMap extends Map(tier = 10)
case object SiegeMap extends Map(tier = 11)
case object ArachnidTombMap extends Map(tier = 11)
case object CrystalOreMap extends Map(tier = 11)
case object ParkMap extends Map(tier = 11)
case object BogMap extends Map(tier = 11)
case object LairMap extends Map(tier = 11)
case object FactoryMap extends Map(tier = 11)
case object MesaMap extends Map(tier = 11)
case object BurialChambersMap extends Map(tier = 11)
case object ChateauMap extends Map(tier = 11)
case object IvoryTempleMap extends Map(tier = 12)
case object ColonnadeMap extends Map(tier = 12)
case object ArsenalMap extends Map(tier = 12)
case object DefiledCathedralMap extends Map(tier = 12)
case object OvergrownShrineMap extends Map(tier = 12)
case object CastleRuinsMap extends Map(tier = 12)
case object VillaMap extends Map(tier = 12)
case object NecropolisMap extends Map(tier = 12)
case object MalformationMap extends Map(tier = 12)
case object CalderaMap extends Map(tier = 13)
case object ReefMap extends Map(tier = 13)
case object RacecourseMap extends Map(tier = 13)
case object CrimsonTempleMap extends Map(tier = 13)
case object DigMap extends Map(tier = 13)
case object CoreMap extends Map(tier = 13)
case object ColosseumMap extends Map(tier = 13)
case object AcidCavernsMap extends Map(tier = 13)
case object ShrineMap extends Map(tier = 13)
case object CourthouseMap extends Map(tier = 14)
case object TerraceMap extends Map(tier = 14)
case object DarkForestMap extends Map(tier = 14)
case object PalaceMap extends Map(tier = 14)
case object BasilicaMap extends Map(tier = 14)
case object SunkenCityMap extends Map(tier = 14)
case object CarcassMap extends Map(tier = 14)
case object TowerMap extends Map(tier = 15)
case object SummitMap extends Map(tier = 15)
case object PrimordialBlocksMap extends Map(tier = 15)
case object DesertSpringMap extends Map(tier = 15)
case object LavaLakeMap extends Map(tier = 15)
case object ForgeOfThePhoenixMap extends Map(tier = 16) {
  override lazy val name: String = "Forge of the Phoenix Map"
}
case object LairOfTheHydraMap extends Map(tier = 16) {
  override lazy val name: String = "Lair of the Hydra Map"
}
case object MazeOfTheMinotaurMap extends Map(tier = 16) {
  override lazy val name: String = "Maze of the Minotaur Map"
}
case object PitOfTheChimeraMap extends Map(tier = 16) {
  override lazy val name: String = "Pit of the Chimera Map"
}
case object VaalTempleMap extends Map(tier = 16)