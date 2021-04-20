package me.amuxix.conditions

import me.amuxix.{Mergeable, Writable}
import me.amuxix.conditions.Influences.Influence

case class HasInfluence(influence: Influence) extends Writable with Mergeable[HasInfluence] {
  override protected def print: String = s"HasInfluence $influence"

  override def canMerge(other: HasInfluence): Boolean = this == other

  override def merge(other: HasInfluence): HasInfluence = this
}
