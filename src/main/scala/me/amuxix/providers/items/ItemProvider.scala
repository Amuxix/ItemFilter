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
  heistEquipment: HeistEquipmentProvider,
)

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
      heistGear <- HeistEquipments.all
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
      HeistEquipmentProvider(heistGear),
    )
  }
}
