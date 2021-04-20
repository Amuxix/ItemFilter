package me.amuxix.conditions

import cats.Show
import me.amuxix.Mergeable
import me.amuxix.conditions.Influences.Influence

case class HasInfluence(influence: Influence) extends Mergeable[HasInfluence] {
  override def canMerge(other: HasInfluence): Boolean = this == other

  override def merge(other: HasInfluence): HasInfluence = this
}

object HasInfluence {
  implicit val show: Show[HasInfluence] = hasInfluence => s"HasInfluence ${hasInfluence.influence}"
}
