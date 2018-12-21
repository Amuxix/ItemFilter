package me.amuxix.items
import me.amuxix.Named

abstract class DivinationCard extends Named {
  def insertValues: String = s"('$name')"
}

object DivinationCard extends FilterClass[DivinationCard] {
  override val all: Seq[DivinationCard] = Seq(
    AMothersPartingGift,
    AbandonedWealth,
    AnarchysPrice,
    AssassinsFavour,
    AtzirisArsenal,
    Audacity,
    BeautyThroughDeath,
    BirthOfTheThree,
    BlessingOfGod,
    BlindVenture,
    BoonOfTheFirstOnes,
    BoundlessRealms,
    BowyersDream,
    CallToTheFirstOnes,
    CartographersDelight,
    ChaoticDisposition,
    CovetedPossession,
    Death,
    DestinedToCrumble,
    DiallasSubjugation,
    DoedresMadness,
    //DyingAnguish,
    EarthDrinker,
    EmperorOfPurity,
    EmperorsLuck,
    ForbiddenPower,
    GemcuttersPromise,
    GiftOfTheGemlingQueen,
    GlimmerOfHope,
    GraveKnowledge,
    HarmonyOfSouls,
    HerMask,
    Heterochromia,
    Hope,
    HouseOfMirrors,
    Hubris,
    Humility,
    HuntersResolve,
    HuntersReward,
    ImmortalResolve,
    JackInTheBox,
    LantadorsLostLove,
    LastHope,
    LeftToFate,
    LightAndTruth,
    LingeringRemnants,
    LostWorlds,
    Loyalty,
    LuckyConnections,
    LuckyDeck,
    LysahsRespite,
    MawrBlaidd,
    MercilessArmament,
    MightIsRight,
    Mitts,
    NoTraces,
    Perfection,
    PrideBeforeTheFall,
    Prosperity,
    RainOfChaos,
    RainTempter,
    Rats,
    Rebirth,
    ScholarOfTheSeas,
    ShardOfFate,
    StruckByLightning,
    TheAdmirer,
    TheAesthete,
    TheArenaChampion,
    TheArmyOfBlood,
    TheArtist,
    TheAvenger,
    TheBattleBorn,
    TheBeast,
    TheBetrayal,
    TheBlazingFire,
    TheBody,
    TheBreach,
    TheBrittleEmperor,
    TheCacophony,
    TheCalling,
    TheCarrionCrow,
    TheCartographer,
    TheCataclysm,
    TheCatalyst,
    TheCelestialJusticar,
    TheCelestialStone,
    TheChainsThatBind,
    TheComingStorm,
    TheConduit,
    TheCursedKing,
    TheDapperProdigy,
    TheDarkMage,
    TheDarkestDream,
    TheDeceiver,
    TheDemoness,
    //TheDevastator, //Not sure if this is in the game.
    TheDoctor,
    TheDoppelganger,
    TheDragon,
    TheDragonsHeart,
    TheDreamer,
    TheDreamland,
    TheDrunkenAristocrat,
    TheEncroachingDarkness,
    TheEndlessDarkness,
    TheEndurance,
    TheEnlightened,
    TheEthereal,
    TheExplorer,
    TheEyeOfTheDragon,
    TheFathomlessDepths,
    TheFeast,
    TheFiend,
    TheFletcher,
    TheFlorasGift,
    TheFormlessSea,
    TheForsaken,
    TheFox,
    TheGambler,
    TheGarishPower,
    TheGemcutter,
    TheGentleman,
    TheGladiator,
    TheHaleHeart,
    TheHarvester,
    TheHermit,
    TheHoarder,
    TheHunger,
    TheImmortal,
    TheIncantation,
    TheInnocent,
    TheInoculated,
    TheInsatiable,
    TheInventor,
    TheIronBard,
    TheJester,
    TheJewellersBoon,
    TheKingsBlade,
    TheKingsHeart,
    TheLastOneStanding,
    TheLich,
    TheLion,
    TheLordInBlack,
    TheLover,
    TheLunarisPriestess,
    TheMaster,
    TheMayor,
    TheMercenary,
    TheMetalsmithsGift,
    TheOath,
    TheObscured,
    TheOffering,
    TheOneWithAll,
    TheOpulent,
    ThePackLeader,
    ThePact,
    ThePenitent,
    ThePoet,
    ThePolymath,
    ThePorcupine,
    ThePriceOfProtection,
    TheProfessor,
    ThePuzzle,
    TheQueen,
    TheRabidRhoa,
    TheRealm,
    TheRisk,
    TheRiteOfElements,
    TheRoadToPower,
    TheRuthlessCeinture,
    TheSaintsTreasure,
    TheSamuraisEye,
    TheScarredMeadow,
    TheScavenger,
    TheScholar,
    TheSephirot,
    TheSigil,
    TheSiren,
    TheSoul,
    TheSparkAndTheFlame,
    TheSpoiledPrince,
    TheStandoff,
    TheStormcaller,
    TheSummoner,
    TheSun,
    TheSurgeon,
    TheSurveyor,
    TheSurvivalist,
    TheSwordKingsSalute,
    TheThaumaturgist,
    TheThrone,
    TheTower,
    TheTraitor,
    TheTrial,
    TheTwilightMoon,
    TheTwins,
    TheTyrant,
    TheUndaunted,
    TheUndisputed,
    TheUnion,
    TheValkyrie,
    TheValleyOfSteelBoxes,
    TheVast,
    TheVisionary,
    TheVoid,
    TheWarden,
    TheWarlord,
    TheWatcher,
    TheWeb,
    TheWiltedRose,
    TheWind,
    TheWitch,
    TheWolf,
    TheWolfsShadow,
    TheWolvenKingsBite,
    TheWolverine,
    TheWorldEater,
    TheWrath,
    TheWretched,
    ThreeFacesInTheDark,
    ThreeVoices,
    ThunderousSkies,
    TimeLostRelic,
    Tranquillity,
    TreasureHunter,
    TurnTheOtherCheek,
    ViniasToken,
    VolatilePower,
    WealthAndPower,
  )
}

case object ADabofInk extends DivinationCard
case object AMothersPartingGift extends DivinationCard {
  override lazy val name: String = "A Mother's Parting Gift"
}
case object AbandonedWealth extends DivinationCard
case object AnarchysPrice extends DivinationCard {
  override lazy val name: String = "Anarchy's Price"
}
case object AssassinsFavour extends DivinationCard {
  override lazy val name: String = "Assassin's Favour"
}
case object AtzirisArsenal extends DivinationCard {
  override lazy val name: String = "Atziri's Arsenal"
}
case object Audacity extends DivinationCard
case object BeautyThroughDeath extends DivinationCard
case object BirthOfTheThree extends DivinationCard
case object BlessingOfGod extends DivinationCard
case object BlindVenture extends DivinationCard
case object BoonOfTheFirstOnes extends DivinationCard
case object BoundlessRealms extends DivinationCard
case object BowyersDream extends DivinationCard {
  override lazy val name: String = "Bowyer's Dream"
}
case object CallToTheFirstOnes extends DivinationCard
case object CartographersDelight extends DivinationCard {
  override lazy val name: String = "Cartographer's Delight"
}
case object ChaoticDisposition extends DivinationCard
case object CovetedPossession extends DivinationCard
case object Death extends DivinationCard
case object DestinedToCrumble extends DivinationCard
case object DiallasSubjugation extends DivinationCard {
  override lazy val name: String = "Dialla's Subjugation"
}
case object DoedresMadness extends DivinationCard {
  override lazy val name: String = "Doedre's Madness"
}
//case object DyingAnguish extends DivinationCard
case object EarthDrinker extends DivinationCard
case object EmperorOfPurity extends DivinationCard
case object EmperorsLuck extends DivinationCard {
  override lazy val name: String = "Emperor's Luck"
}
case object ForbiddenPower extends DivinationCard
case object GemcuttersPromise extends DivinationCard {
  override lazy val name: String = "Gemcutter's Promise"
}
case object GiftOfTheGemlingQueen extends DivinationCard
case object GlimmerOfHope extends DivinationCard
case object GraveKnowledge extends DivinationCard
case object HarmonyOfSouls extends DivinationCard
case object HerMask extends DivinationCard
case object Heterochromia extends DivinationCard
case object Hope extends DivinationCard
case object HouseOfMirrors extends DivinationCard
case object Hubris extends DivinationCard
case object Humility extends DivinationCard
case object HuntersResolve extends DivinationCard {
  override lazy val name: String = "Hunter's Resolve"
}
case object HuntersReward extends DivinationCard {
  override lazy val name: String = "Hunter's Reward"
}
case object ImmortalResolve extends DivinationCard
case object JackInTheBox extends DivinationCard
case object LantadorsLostLove extends DivinationCard {
  override lazy val name: String = "Lantador's Lost Love"
}
case object LastHope extends DivinationCard
case object LeftToFate extends DivinationCard
case object LightAndTruth extends DivinationCard
case object LingeringRemnants extends DivinationCard
case object LostWorlds extends DivinationCard
case object Loyalty extends DivinationCard
case object LuckyConnections extends DivinationCard
case object LuckyDeck extends DivinationCard
case object LysahsRespite extends DivinationCard {
  override lazy val name: String = "Lysah's Respite"
}
case object MawrBlaidd extends DivinationCard
case object MercilessArmament extends DivinationCard
case object MightIsRight extends DivinationCard
case object Mitts extends DivinationCard
case object NoTraces extends DivinationCard
case object Perfection extends DivinationCard
case object PrideBeforeTheFall extends DivinationCard
case object Prosperity extends DivinationCard
case object RainOfChaos extends DivinationCard
case object RainTempter extends DivinationCard
case object Rats extends DivinationCard
case object Rebirth extends DivinationCard
case object ScholarOfTheSeas extends DivinationCard
case object ShardOfFate extends DivinationCard
case object StruckByLightning extends DivinationCard
case object TheAdmirer extends DivinationCard
case object TheAesthete extends DivinationCard
case object TheArenaChampion extends DivinationCard
case object TheArmyOfBlood extends DivinationCard
case object TheArtist extends DivinationCard
case object TheAvenger extends DivinationCard
case object TheBattleBorn extends DivinationCard
case object TheBeast extends DivinationCard
case object TheBetrayal extends DivinationCard
case object TheBlazingFire extends DivinationCard
case object TheBody extends DivinationCard
case object TheBreach extends DivinationCard
case object TheBrittleEmperor extends DivinationCard
case object TheCacophony extends DivinationCard
case object TheCalling extends DivinationCard
case object TheCarrionCrow extends DivinationCard
case object TheCartographer extends DivinationCard
case object TheCataclysm extends DivinationCard
case object TheCatalyst extends DivinationCard
case object TheCelestialJusticar extends DivinationCard
case object TheCelestialStone extends DivinationCard
case object TheChainsThatBind extends DivinationCard
case object TheComingStorm extends DivinationCard
case object TheConduit extends DivinationCard
case object TheCursedKing extends DivinationCard
case object TheDapperProdigy extends DivinationCard
case object TheDarkMage extends DivinationCard
case object TheDarkestDream extends DivinationCard
case object TheDeceiver extends DivinationCard
case object TheDemoness extends DivinationCard
//case object TheDevastator extends DivinationCard
case object TheDoctor extends DivinationCard
case object TheDoppelganger extends DivinationCard
case object TheDragon extends DivinationCard
case object TheDragonsHeart extends DivinationCard {
  override lazy val name: String = "The Dragon's Heart"
}
case object TheDreamer extends DivinationCard
case object TheDreamland extends DivinationCard
case object TheDrunkenAristocrat extends DivinationCard
case object TheEncroachingDarkness extends DivinationCard
case object TheEndlessDarkness extends DivinationCard
case object TheEndurance extends DivinationCard
case object TheEnlightened extends DivinationCard
case object TheEthereal extends DivinationCard
case object TheExplorer extends DivinationCard
case object TheEyeOfTheDragon extends DivinationCard
case object TheFathomlessDepths extends DivinationCard
case object TheFeast extends DivinationCard
case object TheFiend extends DivinationCard
case object TheFletcher extends DivinationCard
case object TheFlorasGift extends DivinationCard {
  override lazy val name: String = "The Flora's Gift"
}
case object TheFormlessSea extends DivinationCard
case object TheForsaken extends DivinationCard
case object TheFox extends DivinationCard
case object TheGambler extends DivinationCard
case object TheGarishPower extends DivinationCard
case object TheGemcutter extends DivinationCard
case object TheGentleman extends DivinationCard
case object TheGladiator extends DivinationCard
case object TheHaleHeart extends DivinationCard
case object TheHarvester extends DivinationCard
case object TheHermit extends DivinationCard
case object TheHoarder extends DivinationCard
case object TheHunger extends DivinationCard
case object TheImmortal extends DivinationCard
case object TheIncantation extends DivinationCard
case object TheInnocent extends DivinationCard
case object TheInoculated extends DivinationCard
case object TheInsatiable extends DivinationCard
case object TheInventor extends DivinationCard
case object TheIronBard extends DivinationCard
case object TheJester extends DivinationCard
case object TheJewellersBoon extends DivinationCard {
  override lazy val name: String = "The Jeweller's Boon"
}
case object TheKingsBlade extends DivinationCard {
  override lazy val name: String = "The King's Blade"
}
case object TheKingsHeart extends DivinationCard {
  override lazy val name: String = "The King's Heart"
}
case object TheLastOneStanding extends DivinationCard
case object TheLich extends DivinationCard
case object TheLifeThief extends DivinationCard
case object TheLion extends DivinationCard
case object TheLordInBlack extends DivinationCard
case object TheLover extends DivinationCard
case object TheLunarisPriestess extends DivinationCard
case object TheMaster extends DivinationCard
case object TheMasterArtisan extends DivinationCard
case object TheMayor extends DivinationCard
case object TheMercenary extends DivinationCard
case object TheMetalsmithsGift extends DivinationCard {
  override lazy val name: String = "The Metalsmith's Gift"
}
case object TheNurse extends DivinationCard
case object TheOath extends DivinationCard
case object TheObscured extends DivinationCard
case object TheOffering extends DivinationCard
case object TheOneWithAll extends DivinationCard
case object TheOpulent extends DivinationCard
case object ThePackLeader extends DivinationCard
case object ThePact extends DivinationCard
case object ThePenitent extends DivinationCard
case object ThePoet extends DivinationCard
case object ThePolymath extends DivinationCard
case object ThePorcupine extends DivinationCard
case object ThePriceOfProtection extends DivinationCard
case object TheProfessor extends DivinationCard
case object ThePuzzle extends DivinationCard
case object TheQueen extends DivinationCard
case object TheRabidRhoa extends DivinationCard
case object TheRealm extends DivinationCard
case object TheRisk extends DivinationCard
case object TheRiteOfElements extends DivinationCard
case object TheRoadToPower extends DivinationCard
case object TheRuthlessCeinture extends DivinationCard
case object TheSacrifice extends DivinationCard
case object TheSaintsTreasure extends DivinationCard {
  override lazy val name: String = "The Saint's Treasure"
}
case object TheSamuraisEye extends DivinationCard {
  override lazy val name: String = "The Samurai's Eye"
}
case object TheScarredMeadow extends DivinationCard
case object TheScavenger extends DivinationCard
case object TheScholar extends DivinationCard
case object TheSephirot extends DivinationCard
case object TheSigil extends DivinationCard
case object TheSiren extends DivinationCard
case object TheSoul extends DivinationCard
case object TheSparkAndTheFlame extends DivinationCard
case object TheSpoiledPrince extends DivinationCard
case object TheStandoff extends DivinationCard
case object TheStormcaller extends DivinationCard
case object TheSummoner extends DivinationCard
case object TheSun extends DivinationCard
case object TheSurgeon extends DivinationCard
case object TheSurveyor extends DivinationCard
case object TheSurvivalist extends DivinationCard
case object TheSwordKingsSalute extends DivinationCard {
  override lazy val name: String = "The Sword King's Salute"
}
case object TheThaumaturgist extends DivinationCard
case object TheThrone extends DivinationCard
case object TheTower extends DivinationCard
case object TheTraitor extends DivinationCard
case object TheTrial extends DivinationCard
case object TheTwilightMoon extends DivinationCard
case object TheTwins extends DivinationCard
case object TheTyrant extends DivinationCard
case object TheUndaunted extends DivinationCard
case object TheUndisputed extends DivinationCard
case object TheUnion extends DivinationCard
case object TheValkyrie extends DivinationCard
case object TheValleyOfSteelBoxes extends DivinationCard
case object TheVast extends DivinationCard
case object TheVisionary extends DivinationCard
case object TheVoid extends DivinationCard
case object TheWarden extends DivinationCard
case object TheWarlord extends DivinationCard
case object TheWatcher extends DivinationCard
case object TheWeb extends DivinationCard
case object TheWiltedRose extends DivinationCard
case object TheWind extends DivinationCard
case object TheWitch extends DivinationCard
case object TheWolf extends DivinationCard
case object TheWolfsShadow extends DivinationCard {
  override lazy val name: String = "The Wolf's Shadow"
}
case object TheWolvenKingsBite extends DivinationCard {
  override lazy val name: String = "The Wolven King's Bite"
}
case object TheWolverine extends DivinationCard
case object TheWorldEater extends DivinationCard
case object TheWrath extends DivinationCard
case object TheWretched extends DivinationCard
case object ThreeFacesInTheDark extends DivinationCard
case object ThreeVoices extends DivinationCard
case object ThunderousSkies extends DivinationCard
case object TimeLostRelic extends DivinationCard {
  override lazy val name: String = "Time-Lost Relic"
}
case object Tranquillity extends DivinationCard
case object TreasureHunter extends DivinationCard
case object TurnTheOtherCheek extends DivinationCard
case object ViniasToken extends DivinationCard {
  override lazy val name: String = "Vinia's Token"
}
case object VolatilePower extends DivinationCard
case object WealthAndPower extends DivinationCard
