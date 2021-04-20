package me.amuxix.providers.items

import cats.data.NonEmptyList
import me.amuxix.items.HeistEquipment

case class HeistEquipmentProvider(all: NonEmptyList[HeistEquipment]) extends BasicProvider[HeistEquipment]