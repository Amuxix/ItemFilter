package me.amuxix.providers.items

import cats.effect.IO
import me.amuxix.database._

private[providers] case class ItemProvider (
  bases: BasesProvider,
  currencies: CurrenciesProvider,
  currencyFragments: CurrencyFragmentsProvider,
  divinationCards: DivinationCardsProvider,
  essences: EssencesProvider,
  incubators: IncubatorsProvider,
  incursionItems: IncursionItemsProvider,
  mapFragmentFragments: MapFragmentFragmentsProvider,
  mapFragments: MapFragmentsProvider,
  maps: MapsProvider,
  metamorphSamples: MetamorphSamplesProvider,
  prophecies: PropheciesProvider,
  resonators: ResonatorsProvider,
  uniques: UniquesProvider,
  watchstones: WatchstonesProvider,
)

/*
import cats.data.NonEmptyList
import me.amuxix.items
import me.amuxix.items._
import me.amuxix.items.currency._

case class ItemProvider (
  basesProvider: BasesProvider,
  currenciesProvider: CurrenciesProvider,
  currencyFragmentsProvider: CurrencyFragmentsProvider,
  divinationCardsProvider: DivinationCardsProvider,
  essencesProvider: EssencesProvider,
  incubatorsProvider: IncubatorsProvider,
  incursionItemsProvider: IncursionItemsProvider,
  mapFragmentFragmentsProvider: MapFragmentFragmentsProvider,
  mapFragmentsProvider: MapFragmentsProvider,
  mapsProvider: MapsProvider,
  metamorphSamplesProvider: MetamorphSamplesProvider,
  propheciesProvider: PropheciesProvider,
  resonatorsProvider: ResonatorsProvider,
  uniquesProvider: UniquesProvider,
  watchstonesProvider: WatchstonesProvider,
) {
  lazy val bases: NonEmptyList[Base] = basesProvider.all
  lazy val currencies: NonEmptyList[Currency] = currenciesProvider.all
  lazy val currencyFragments: NonEmptyList[CurrencyFragment] = currencyFragmentsProvider.all
  lazy val divinationCards: NonEmptyList[DivinationCard] = divinationCardsProvider.all
  lazy val essences: NonEmptyList[Essence] = essencesProvider.all
  lazy val incubators: NonEmptyList[Incubator] = incubatorsProvider.all
  lazy val incursionItems: NonEmptyList[IncursionItem] = incursionItemsProvider.all
  lazy val mapFragmentFragments: NonEmptyList[MapFragmentFragment] = mapFragmentFragmentsProvider.all
  lazy val mapFragments: NonEmptyList[MapFragment] = mapFragmentsProvider.all
  lazy val maps: NonEmptyList[items.Map] = mapsProvider.all
  lazy val metamorphSamples: NonEmptyList[MetamorphSample] = metamorphSamplesProvider.all
  lazy val prophecies: NonEmptyList[Prophecy] = propheciesProvider.all
  lazy val resonators: NonEmptyList[Resonator] = resonatorsProvider.all
  lazy val uniques: NonEmptyList[UniqueItem] = uniquesProvider.all
  lazy val watchstones: NonEmptyList[Watchstone] = watchstonesProvider.all
}*/

object ItemProvider {
  def fromDB: IO[ItemProvider] = {
    for {
      bases <- Bases.all
      currencies <- Currencies.all
      currencyFragments <- CurrencyFragments.all
      divinationCards <- DivinationCards.all
      essences <- Essences.all
      incubators <- Incubators.all
      incursion <- IncursionItems.all
      mapFragmentFragments <- MapFragmentFragments.all
      mapFragments <- MapFragments.all
      maps <- Maps.all
      metamorphSamples <- MetamorphSamples.all
      prophecies <- Prophecies.all
      resonators <- Resonators.all
      uniques <- Uniques.all
      watchstones <- Watchstones.all
    } yield new ItemProvider(
      BasesProvider(bases),
      CurrenciesProvider(currencies),
      CurrencyFragmentsProvider(currencyFragments),
      DivinationCardsProvider(divinationCards),
      EssencesProvider(essences),
      IncubatorsProvider(incubators),
      IncursionItemsProvider(incursion),
      MapFragmentFragmentsProvider(mapFragmentFragments),
      MapFragmentsProvider(mapFragments),
      MapsProvider(maps),
      MetamorphSamplesProvider(metamorphSamples),
      PropheciesProvider(prophecies),
      ResonatorsProvider(resonators),
      UniquesProvider(uniques),
      WatchstonesProvider(watchstones),
    )
  }
}
