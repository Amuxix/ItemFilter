package me.amuxix.conditions

import cats.Show
import me.amuxix.Mergeable
import me.amuxix.conditions.Influences.Influence

object HasInfluence {
  implicit val show: Show[HasInfluence] = hasInfluence => s"HasInfluence ${hasInfluence.influence}"

  implicit val mergeable: Mergeable[HasInfluence] = Mergeable.equal(_.influence)
}

case class HasInfluence(influence: Influence)
