package me.amuxix.database

import me.amuxix.database.PostgresProfile.API._
import me.amuxix.items.MetamorphSample

class MetamorphSamplesTable(tag: Tag) extends Table[MetamorphSample](tag, "metamorph_samples") with CommonColumns[MetamorphSample] {
  override def * =
    (
      name,
      dropEnabled,
      ).mapTo[MetamorphSample]
}

object MetamorphSamples extends BasicOperations[MetamorphSample, MetamorphSamplesTable](new MetamorphSamplesTable(_))