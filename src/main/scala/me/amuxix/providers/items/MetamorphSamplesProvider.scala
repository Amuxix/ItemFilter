package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.MetamorphSample

case class MetamorphSamplesProvider(all: NonEmptyList[MetamorphSample]) extends BasicProvider[MetamorphSample]
