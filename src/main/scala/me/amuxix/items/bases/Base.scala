package me.amuxix.items.bases

import me.amuxix._
import me.amuxix.actions.Action
import me.amuxix.actions.Color.{darkRed, goodYellow}
import me.amuxix.conditions._
import me.amuxix.items.Item
import me.amuxix.items.bases.accessories._
import me.amuxix.items.bases.armour._
import me.amuxix.items.bases.weapons._

abstract class Base(height: Int, width: Int, val dropLevel: Int, `class`: ItemClass, minDropBuffer: Int = 5) extends Item(1, 1) with Named with ImplicitConversions {
  def this(height: Int, width: Int, dropLevel: Int, `class`: String, minDropBuffer: Int) = this(height, width, dropLevel, ItemClass(`class`), minDropBuffer)
  def this(height: Int, width: Int, dropLevel: Int, `class`: String) = this(height, width, dropLevel, ItemClass(`class`))

  def bestModsDropLevel: Int = 84

  def baseType: BaseType = BaseType(name.replaceAll("([a-z])([A-Z])", "$1 $2"))

  def closeToZoneLevel(howClose: ItemLevel, rarity: Option[Rarity] = Rare): Condition = Condition(
    base = Some(this.baseType),
    itemLevel = if (Base.bestEquipment contains this) None else Some(howClose),
    rarity = rarity
  )

  def blocksOfBestRaresForZoneLevel() = Block(
    closeToZoneLevel(ItemLevel("<=", this.dropLevel + minDropBuffer max this.dropLevel / 10)),
    Action(
      textColor = goodYellow,
    )
  )

  def blocksOfGoodRaresForZoneLevel() = Block(
    closeToZoneLevel(ItemLevel("<=", this.dropLevel + 20)),
    Action(
      size = 25
    )
  )

  def blocksOfBestWhitesForZoneLevel() = Block(
    closeToZoneLevel(ItemLevel("<=", this.dropLevel + minDropBuffer max this.dropLevel / 10), White)
  )
}

sealed trait BestBaseBlocks extends ImplicitConversions { this: Base =>
  val rare: Block = Block(
    Condition(base = Some(this.baseType), itemLevel = (">=", this.bestModsDropLevel), rarity = Rare),
    Action(textColor = goodYellow, backgroundColor = darkRed, borderColor = goodYellow)
  )
  val craftting: Block = Block(
    Condition(base = Some(this.baseType), itemLevel = (">=", this.bestModsDropLevel), rarity = ("<", Rare))
  ).hidden
}

abstract class Armour(height: Int, width: Int, dropLevel: Int, `class`: String) extends Base(height, width, dropLevel, `class`) with BestBaseBlocks

abstract class Weapon(height: Int, width: Int, dropLevel: Int, `class`: String) extends Base(height, width, dropLevel, `class`) with BestBaseBlocks {
  override def bestModsDropLevel: Int = 83
}

abstract class Accessory(dropLevel: Int, `class`: String) extends Base(1, 1, dropLevel, `class`) with BestBaseBlocks
// format: off
object Base {
  val oneHandedAxes: Seq[OneHandedAxe] = Seq(RustedHatchet, JadeHatchet, BoardingAxe, Cleaver, BroadAxe, ArmingAxe, DecorativeAxe, SpectralAxe, EtchedHatchet, JasperAxe, Tomahawk, WristChopper, WarAxe, ChestSplitter, CeremonialAxe, WraithAxe, EngravedHatchet, KaruiAxe, SiegeAxe, ReaverAxe, ButcherAxe, VaalHatchet, RoyalAxe, InfernalAxe, RunicHatchet)
  val twoHandedAxes: Seq[TwoHandedAxe] = Seq(StoneAxe, JadeChopper, Woodsplitter, Poleaxe, DoubleAxe, GildedAxe, ShadowAxe, DaggerAxe, JasperChopper, TimberAxe, HeadsmanAxe, Labrys, NobleAxe, AbyssalAxe, KaruiChopper, TalonAxe, SunderingAxe, EzomyteAxe, VaalAxe, DespotAxe, VoidAxe, Fleshripper)
  val bows: Seq[Bow] = Seq(CrudeBow, ShortBow, LongBow, CompositeBow, RecurveBow, BoneBow, RoyalBow, DeathBow, GroveBow, ReflexBow, DecurveBow, CompoundBow, SniperBow, IvoryBow, HighbornBow, DecimationBow, ThicketBow, SteelwoodBow, CitadelBow, RangerBow, AssassinBow, SpineBow, ImperialBow, HarbingerBow, MarakethBow)
  val claws: Seq[Claw] = Seq(NailedFist, SharktoothClaw, Awl, CatsPaw, Blinder, TimewornClaw, SparklingClaw, FrightClaw, DoubleClaw, ThresherClaw, Gouger, TigersPaw, GutRipper, PrehistoricClaw, NobleClaw, EagleClaw, TwinClaw, GreatWhiteClaw, ThroatStabber, HellionsPaw, EyeGouger, VaalClaw, ImperialClaw, TerrorClaw, GeminiClaw)
  val daggers: Seq[Dagger] = Seq(GlassShank, SkinningKnife, CarvingKnife, Stiletto, BootKnife, CopperKris, Skean, ImpDagger, FlayingKnife, ProngDagger, ButcherKnife, Poignard, BootBlade, GoldenKris, RoyalSkean, FiendDagger, Trisula, GuttingKnife, SlaughterKnife, Ambusher, EzomyteDagger, PlatinumKris, ImperialSkean, DemonDagger, Sai)
  val oneHandedMaces: Seq[OneHandedMace] = Seq(DriftwoodClub, TribalClub, SpikedClub, StoneHammer, WarHammer, BladedMace, CeremonialMace, DreamMace, WyrmMace, PetrifiedClub, BarbedClub, RockBreaker, BattleHammer, FlangedMace, OrnateMace, PhantomMace, DragonMace, AncestralClub, Tenderizer, Gavel, LegionHammer, Pernarch, AuricMace, NightmareMace, BehemothMace)
  val twoHandedMaces: Seq[TwoHandedMace] = Seq(DriftwoodMaul, TribalMaul, Mallet, Sledgehammer, JaggedMaul, BrassMaul, FrightMaul, MorningStar, TotemicMaul, GreatMallet, Steelhead, SpinyMaul, PlatedMaul, DreadMaul, SolarMaul, KaruiMaul, ColossusMallet, Piledriver, Meatgrinder, ImperialMaul, TerrorMaul, CoronalMaul)
  val sceptres: Seq[Sceptre] = Seq(DriftwoodSceptre, DarkwoodSceptre, BronzeSceptre, QuartzSceptre, IronSceptre, OchreSceptre, RitualSceptre, ShadowSceptre, GrinningFetish, HornedSceptre, Sekhem, CrystalSceptre, LeadSceptre, BloodSceptre, RoyalSceptre, AbyssalSceptre, StagSceptre, KaruiSceptre, TyrantsSekhem, OpalSceptre, PlatinumSceptre, VaalSceptre, CarnalSceptre, VoidSceptre, SambarSceptre)
  val staves: Seq[Staff] = Seq(GnarledBranch, PrimitiveStaff, LongStaff, IronStaff, CoiledStaff, RoyalStaff, VileStaff, CrescentStaff, WoodfulStaff, Quarterstaff, MilitaryStaff, SerpentineStaff, HighbornStaff, FoulStaff, MoonStaff, PrimordialStaff, Lathi, EzomyteStaff, MaelströmStaff, ImperialStaff, JudgementStaff, EclipseStaff)
  val oneHandedSword: Seq[OneHandedSword] = Seq(RustedSword, CopperSword, Sabre, BroadSword, WarSword, AncientSword, ElegantSword, DuskBlade, HookSword, VarisciteBlade, Cutlass, Baselard, BattleSword, ElderSword, GracefulSword, TwilightBlade, Grappler, GemstoneSword, CorsairSword, Gladius, LegionSword, VaalBlade, EternalSword, MidnightBlade, TigerHook)
  val twoHandedSwords: Seq[TwoHandedSword] = Seq(CorrodedBlade, Longsword, BastardSword, TwoHandedSword, EtchedGreatsword, OrnateSword, SpectralSword, CurvedBlade, ButcherSword, FootmanSword, HighlandBlade, EngravedGreatsword, TigerSword, WraithSword, LitheBlade, HeadmansSword, ReaverSword, EzomyteBlade, VaalGreatsword, LionSword, InfernalSword, ExquisiteBlade)
  val thrustingOneHandedSword: Seq[ThrustingOneHandedSword] = Seq(RustedSpike, WhaleboneRapier, BatteredFoil, BasketRapier, JaggedFoil, AntiqueRapier, ElegantFoil, ThornRapier, Smallsword, WyrmboneRapier, BurnishedFoil, Estoc, SerratedFoil, PrimevalRapier, FancyFoil, ApexRapier, CourtesanSword, DragonboneRapier, TemperedFoil, Pecoraro, SpiraledFoil, VaalRapier, JewelledFoil, HarpyRapier, DragoonSword)
  val wands: Seq[Wand] = Seq(DriftwoodWand, GoatsHorn, CarvedWand, QuartzWand, SpiraledWand, SageWand, PaganWand, FaunsHorn, EngravedWand, CrystalWand, SerpentWand, OmenWand, HeathenWand, DemonsHorn, ImbuedWand, OpalWand, TornadoWand, ProphecyWand, ProfaneWand)
  val weapons: Seq[Seq[Weapon]] = Seq(oneHandedAxes, twoHandedAxes, bows, claws, daggers, oneHandedMaces, sceptres, staves, oneHandedSword, twoHandedSwords, thrustingOneHandedSword, wands)

  val armourBodyArmours: Seq[BodyArmour] = Seq(PlateVest, Chestplate, CopperPlate, WarPlate, FullPlate, ArenaPlate, LordlyPlate, BronzePlate, BattlePlate, SunPlate, ColosseumPlate, MajesticPlate, GoldenPlate, CrusaderPlate, AstralPlate, GladiatorPlate, GloriousPlate)
  val evasionBodyArmours: Seq[BodyArmour] = Seq(ShabbyJerkin, StrappedLeather, BuckskinTunic, WildLeather, FullLeather, SunLeather, ThiefsGarb, EelskinTunic, FrontierLeather, GloriousLeather, CoronalLeather, CutthroatsGarb, SharkskinTunic, DestinyLeather, ExquisiteLeather, ZodiacLeather, AssassinsGarb)
  val energyShieldBodyArmours: Seq[BodyArmour] = Seq(SimpleRobe, SilkenVest, ScholarsRobe, SilkenGarb, MagesVestment, SilkRobe, CabalistRegalia, SagesRobe, SilkenWrap, ConjurersVestment, SpidersilkRobe, DestroyerRegalia, SavantsRobe, NecromancerSilks, OccultistsVestment, WidowsilkRobe, VaalRegalia)
  val armourEvasionBodyArmours: Seq[BodyArmour] = Seq(ScaleVest, LightBrigandine, ScaleDoublet, InfantryBrigandine, FullScaleArmour, SoldiersBrigandine, FieldLamellar, WyrmscaleDoublet, HussarBrigandine, FullWyrmscale, CommandersBrigandine, BattleLamellar, DragonscaleDoublet, DesertBrigandine, FullDragonscale, GeneralsBrigandine, TriumphantLamellar)
  val armourEnergyShieldBodyArmours: Seq[BodyArmour] = Seq(ChainmailVest, ChainmailTunic, RingmailCoat, ChainmailDoublet, FullRingmail, FullChainmail, HolyChainmail, LatticedRingmail, CrusaderChainmail, OrnateRingmail, ChainHauberk, DevoutChainmail, LoricatedRingmail, ConquestChainmail, ElegantRingmail, SaintsHauberk, SaintlyChainmail)
  val evasionEnergyShieldBodyArmours: Seq[BodyArmour] = Seq(PaddedVest, OiledVest, PaddedJacket, OiledCoat, ScarletRaiment, WaxedGarb, BoneArmour, QuiltedJacket, SleekCoat, CrimsonRaiment, LacqueredGarb, CryptArmour, SentinelJacket, VarnishedCoat, BloodRaiment, SadistGarb, CarnalArmour)
  val bodyArmours: Seq[Seq[BodyArmour]] = Seq(armourBodyArmours, evasionBodyArmours, energyShieldBodyArmours, armourEvasionBodyArmours, armourEnergyShieldBodyArmours, evasionEnergyShieldBodyArmours)

  val armourBoots: Seq[Boots] = Seq(IronGreaves, SteelGreaves, PlatedGreaves, ReinforcedGreaves, AntiqueGreaves, AncientGreaves, GoliathGreaves, VaalGreaves, TitanGreaves)
  val evasionBoots: Seq[Boots] = Seq(RawhideBoots, GoathideBoots, DeerskinBoots, NubuckBoots, EelskinBoots, SharkskinBoots, ShagreenBoots, StealthBoots, SlinkBoots)
  val energyShieldBoots: Seq[Boots] = Seq(WoolShoes, VelvetSlippers, SilkSlippers, ScholarBoots, SatinSlippers, SamiteSlippers, ConjurerBoots, ArcanistSlippers, SorcererBoots)
  val armourEvasionBoots: Seq[Boots] = Seq(LeatherscaleBoots, IronscaleBoots, BronzescaleBoots, SteelscaleBoots, SerpentscaleBoots, WyrmscaleBoots, HydrascaleBoots, DragonscaleBoots, TwoTonedBoots)
  val armourEnergyShieldBoots: Seq[Boots] = Seq(ChainBoots, RingmailBoots, MeshBoots, RivetedBoots, ZealotBoots, SoldierBoots, LegionBoots, CrusaderBoots)
  val evasionEnergyShieldBoots: Seq[Boots] = Seq(WrappedBoots, StrappedBoots, ClaspedBoots, ShackledBoots, TrapperBoots, AmbushBoots, CarnalBoots, AssassinsBoots, MurderBoots)
  val boots: Seq[Seq[Boots]] = Seq(armourBoots, evasionBoots, energyShieldBoots, armourEvasionBoots, armourEnergyShieldBoots, evasionEnergyShieldBoots)

  val armourGloves: Seq[Gloves] = Seq(IronGauntlets, PlatedGauntlets, BronzeGauntlets, SteelGauntlets, AntiqueGauntlets, AncientGauntlets, GoliathGauntlets, VaalGauntlets, TitanGauntlets, SpikedGloves)
  val evasionGloves: Seq[Gloves] = Seq(RawhideGloves, GoathideGloves, DeerskinGloves, NubuckGloves, EelskinGloves, SharkskinGloves, ShagreenGloves, StealthGloves, SlinkGloves, GrippedGloves)
  val energyShieldGloves: Seq[Gloves] = Seq(WoolGloves, VelvetGloves, SilkGloves, EmbroideredGloves, SatinGloves, SamiteGloves, ConjurerGloves, ArcanistGloves, SorcererGloves, FingerlessSilkGloves)
  val armourEvasionGloves: Seq[Gloves] = Seq(FishscaleGauntlets, IronscaleGauntlets, BronzescaleGauntlets, SteelscaleGauntlets, SerpentscaleGauntlets, WyrmscaleGauntlets, HydrascaleGauntlets, DragonscaleGauntlets)
  val armourEnergyShieldGloves: Seq[Gloves] = Seq(ChainGloves, RingmailGloves, MeshGloves, RivetedGloves, ZealotGloves, SoldierGloves, LegionGloves, CrusaderGloves)
  val evasionEnergyShieldGloves: Seq[Gloves] = Seq(WrappedMitts, StrappedMitts, ClaspedMitts, TrapperMitts, AmbushMitts, CarnalMitts, AssassinsMitts, MurderMitts)
  val gloves: Seq[Seq[Gloves]] = Seq(armourGloves, evasionGloves, energyShieldGloves, armourEvasionGloves, armourEnergyShieldGloves, evasionEnergyShieldGloves)

  val armourHelmets: Seq[Helmet] = Seq(IronHat, ConeHelmet, BarbuteHelmet, CloseHelmet, GladiatorHelmet, ReaverHelmet, SiegeHelmet, SamiteHelmet, EzomyteBurgonet, RoyalBurgonet, EternalBurgonet)
  val evasionHelmets: Seq[Helmet] = Seq(LeatherCap, Tricorne, LeatherHood, WolfPelt, HunterHood, NobleTricorne, UrsinePelt, SilkenHood, SinnerTricorne, LionPelt)
  val energyShieldHelmets: Seq[Helmet] = Seq(VineCirclet, IronCirclet, TortureCage, TribalCirclet, BoneCirclet, LunarisCirclet, SteelCirclet, NecromancerCirclet, SolarisCirclet, MindCage, HubrisCirclet)
  val armourEvasionHelmets: Seq[Helmet] = Seq(BatteredHelm, Sallet, VisoredSallet, GildedSallet, SecutorHelm, FencerHelm, LacqueredHelmet, FlutedBascinet, PigFacedBascinet, NightmareBascinet)
  val armourEnergyShieldHelmets: Seq[Helmet] = Seq(RustedCoif, SoldierHelmet, GreatHelmet, CrusaderHelmet, AventailHelmet, ZealotHelmet, GreatCrown, MagistrateCrown, ProphetCrown, PraetorCrown, BoneHelmet)
  val evasionEnergyShieldHelmets: Seq[Helmet] = Seq(ScareMask, PlagueMask, IronMask, FestivalMask, GoldenMask, RavenMask, CallousMask, RegicideMask, HarlequinMask, VaalMask, DeicideMask)
  val helmets: Seq[Seq[Helmet]] = Seq(armourHelmets, evasionHelmets, energyShieldHelmets, armourEvasionHelmets, armourEnergyShieldHelmets, evasionEnergyShieldHelmets)

  val armourShields: Seq[Shield] = Seq(SplinteredTowerShield, CorrodedTowerShield, RawhideTowerShield, CedarTowerShield, CopperTowerShield, ReinforcedTowerShield, PaintedTowerShield, BuckskinTowerShield, MahoganyTowerShield, BronzeTowerShield, GirdedTowerShield, CrestedTowerShield, ShagreenTowerShield, EbonyTowerShield, EzomyteTowerShield, ColossalTowerShield, PinnacleTowerShield)
  val evasionShields: Seq[Shield] = Seq(GoathideBuckler, PineBuckler, PaintedBuckler, HammeredBuckler, WarBuckler, GildedBuckler, OakBuckler, EnameledBuckler, CorrugatedBuckler, BattleBuckler, GoldenBuckler, IronwoodBuckler, LacqueredBuckler, VaalBuckler, CrusaderBuckler, ImperialBuckler)
  val energyShieldShields: Seq[Shield] = Seq(TwigSpiritShield, YewSpiritShield, BoneSpiritShield, TarnishedSpiritShield, JinglingSpiritShield, BrassSpiritShield, WalnutSpiritShield, IvorySpiritShield, AncientSpiritShield, ChimingSpiritShield, ThoriumSpiritShield, LacewoodSpiritShield, FossilisedSpiritShield, VaalSpiritShield, HarmonicSpiritShield, TitaniumSpiritShield)
  val armourEvasionShields: Seq[Shield] = Seq(RottedRoundShield, FirRoundShield, StuddedRoundShield, ScarletRoundShield, SplendidRoundShield, MapleRoundShield, SpikedRoundShield, CrimsonRoundShield, BaroqueRoundShield, TeakRoundShield, SpinyRoundShield, CardinalRoundShield, ElegantRoundShield)
  val armourEnergyShieldShields: Seq[Shield] = Seq(PlankKiteShield, LindenKiteShield, ReinforcedKiteShield, LayeredKiteShield, CeremonialKiteShield, EtchedKiteShield, SteelKiteShield, LaminatedKiteShield, AngelicKiteShield, BrandedKiteShield, ChampionKiteShield, MosaicKiteShield, ArchonKiteShield)
  val evasionEnergyShieldShields: Seq[Shield] = Seq(SpikedBundle, DriftwoodSpikedShield, AlloyedSpikedShield, BurnishedSpikedShield, OrnateSpikedShield, RedwoodSpikedShield, CompoundSpikedShield, PolishedSpikedShield, SovereignSpikedShield, AlderSpikedShield, EzomyteSpikedShield, MirroredSpikedShield, SupremeSpikedShield)
  val shields: Seq[Seq[Shield]] = Seq(armourShields, evasionShields, energyShieldShields, armourEvasionShields, armourEnergyShieldShields, evasionEnergyShieldShields)

  val quivers: Seq[Quiver] = Seq(TwoPointArrowQuiver, SerratedArrowQuiver, SharktoothArrowQuiver, BluntArrowQuiver, FireArrowQuiver, BroadheadArrowQuiver, PenetratingArrowQuiver, SpikePointArrowQuiver)

  val armours: Seq[Seq[Armour]] = bodyArmours ++ boots ++ gloves ++ helmets ++ shields


  val lifeFlasks: Seq[LifeFlask] = Seq(SmallLifeFlask, MediumLifeFlask, LargeLifeFlask, GreaterLifeFlask, GrandLifeFlask, GiantLifeFlask, ColossalLifeFlask, SacredLifeFlask, HallowedLifeFlask, SanctifiedLifeFlask, DivineLifeFlask, EternalLifeFlask)
  val manaFlasks: Seq[ManaFlask] = Seq(SmallManaFlask, MediumManaFlask, LargeManaFlask, GreaterManaFlask, GrandManaFlask, GiantManaFlask, ColossalManaFlask, SacredManaFlask, HallowedManaFlask, SanctifiedManaFlask, DivineManaFlask, EternalManaFlask)
  val hybridFlasks: Seq[HybridFlask] = Seq(SmallHybridFlask, MediumHybridFlask, LargeHybridFlask, ColossalHybridFlask, SacredHybridFlask, HallowedHybridFlask)
  val flasks: Seq[Seq[Flask]] = Seq(lifeFlasks, manaFlasks, hybridFlasks)

  val utilityFlasks: Seq[UtilityFlask] = Seq(QuicksilverFlask, BismuthFlask, StibniteFlask, AmethystFlask, RubyFlask, SapphireFlask, TopazFlask, SilverFlask, AquamarineFlask, GraniteFlask, JadeFlask, QuartzFlask, SulphurFlask, BasaltFlask, DiamondFlask)

  val amulets: Seq[Amulet] = Seq(CoralAmulet, PauaAmulet, AmberAmulet, JadeAmulet, LapisAmulet, GoldAmulet, AgateAmulet, CitrineAmulet, TurquoiseAmulet, OnyxAmulet, MarbleAmulet, BluePearlAmulet)
  val rings: Seq[Ring] = Seq(CoralRing, IronRing, PauaRing, UnsetRing, SapphireRing, TopazRing, RubyRing, DiamondRing, GoldRing, MoonstoneRing, TwoStoneRing, AmethystRing, PrismaticRing, OpalRing, SteelRing)
  val belts: Seq[Belt] = Seq(ChainBelt, RusticSash, StygianVise, HeavyBelt, LeatherBelt, ClothBelt, StuddedBelt, VanguardBelt, CrystalBelt)

  val accessories: Seq[Accessory] = amulets ++ rings ++ belts

  val bestEquipment: Seq[Base with BestBaseBlocks] = (weapons ++ armours).flatMap(_.takeRight(2)) ++ Seq(SpikePointArrowQuiver, BroadheadArrowQuiver).sortBy(_.dropLevel)(implicitly[Ordering[Int]].reverse)
  val allEquipment: Seq[Base] = (weapons ++ armours).flatten.sortBy(_.dropLevel)(implicitly[Ordering[Int]].reverse)
}
// format: on