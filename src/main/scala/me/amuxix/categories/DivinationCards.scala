package me.amuxix.categories

import me.amuxix.actions.Action
import me.amuxix.actions.Color._
import me.amuxix.actions.Sound._
import me.amuxix.conditions.Condition
import me.amuxix.{Block, FilterLevel}

object DivinationCards extends Category {
  val t0 = Block(
    Condition(
      base = Seq("House of Mirrors", "The Doctor", "The Fiend", "Mawr Blaidd", "The Last One Standing", "The Offering", "The Spark and the Flame", "The Immortal", "The Ethereal", "Hunter's Reward", "Abandoned Wealth", "Bowyer's Dream", "The Celestial Justicar", "The Queen", "The Polymath", "Wealth and Power", "The Vast", "The Enlightened", "The Brittle Emperor", "The King's Heart", "Pride Before the Fall", "The Artist", "The Hunger"),
      `class` = "Divination",
    ),
    Action(
      size = 45,
      sound = myths.quieter,
      backgroundColor = divinationBlue,
      textColor = black,
      borderColor = black,
    )
  )

  val t1 = Block(
    Condition(
      base = Seq("The Thaumaturgist", "Last Hope", "The Saint's Treasure", "The Dapper Prodigy", "The Soul", "Chaotic Disposition", "The Sephirot", "Heterochromia", "The Stormcaller", "The Warlord", "The Wolven King's Bite", "The Fletcher", "The Hoarder", "The Void", "The Porcupine", "The Aesthete", "The Chains that Bind", "The Wolf", "The Standoff", "The Formless Sea", "The Valkyrie", "Emperor of Purity", "The Risk", "Earth Drinker", "Lucky Deck", "The Gladiator", "The Cartographer", "Vinia's Token", "A Mother's Parting Gift"),
      `class` = "Divination",
    ),
    Action(
      size = 40,
      sound = epic.quieter,
      backgroundColor = divinationBlue.darken,
      textColor = black,
      borderColor = black,
    )
  )

  val t2 = Block(
    Condition(
      base = Seq("The Valley of Steel Boxes", "Merciless Armament", "The Tyrant", "The Inventor", "The Dark Mage", "The Arena Champion", "Treasure Hunter", "The Fox", "Gemcutter's Promise", "The Wind", "Atziri's Arsenal", "The Avenger", "The Pact", "The Conduit", "Lucky Connections", "The Wrath", "The Opulent", "Dialla's Subjugation", "The Forsaken", "Lost Worlds", "The Union", "Gift of the Gemling Queen", "Scholar of the Seas", "Lingering Remnants", "The Road to Power", "Struck by Lightning", "Time-Lost Relic", "Grave Knowledge", "Humility", "The Dragon", "The Trial", "Rats", "The Lion", "The Harvester", "The Penitent", "Might is Right", "The Surveyor", "Lysah's Respite", "The Body", "Jack in the Box", "The Traitor", "Glimmer of Hope", "The One With All", "The Wretched", "The Jester", "Audacity", "The Spoiled Prince", "The Poet", "The Siren", "The Survivalist", "Hope", "Blind Venture", "Boundless Realms", "The Encroaching Darkness", "Rain Tempter", "Call to the First Ones"),
      `class` = "Divination",
    ),
    Action(
      size = 36,
      sound = divCards,
      backgroundColor = black,
      textColor = divinationBlue,
      borderColor = divinationBlue,
    )
  )

  val rest = Block(
    Condition(
      `class` = "Divination",
    ),
    Action(
      backgroundColor = black,
      textColor = divinationBlue,
    )
  )

  override def categoryBlocks(filterLevel: FilterLevel) = Seq(t0, t1, t2, rest)
}
