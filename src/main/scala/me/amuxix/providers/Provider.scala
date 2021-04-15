package me.amuxix.providers

import me.amuxix.items.Item
import me.amuxix.providers.items._
import me.amuxix.providers.prices.PriceProvider

class Provider(
  prices: PriceProvider,
  items: ItemProvider,
) {
  def getPriceOf(item: Item): Option[Double] = prices.getPriceOf(item)

  lazy val bases: BasesProvider = items.bases
  lazy val currencies: CurrenciesProvider = items.currencies
  lazy val currencyFragments: CurrencyFragmentsProvider = items.currencyFragments
  lazy val divinationCards: DivinationCardsProvider = items.divinationCards
  lazy val essences: EssencesProvider = items.essences
  lazy val incubators: IncubatorsProvider = items.incubators
  lazy val incursionItems: IncursionItemsProvider = items.incursionItems
  lazy val mapFragmentFragments: MapFragmentFragmentsProvider = items.mapFragmentFragments
  lazy val mapFragments: MapFragmentsProvider = items.mapFragments
  lazy val maps: MapsProvider = items.maps
  lazy val metamorphSamples: MetamorphSamplesProvider = items.metamorphSamples
  lazy val prophecies: PropheciesProvider = items.prophecies
  lazy val resonators: ResonatorsProvider = items.resonators
  lazy val uniques: UniquesProvider = items.uniques
  lazy val watchstones: WatchstonesProvider = items.watchstones
}
