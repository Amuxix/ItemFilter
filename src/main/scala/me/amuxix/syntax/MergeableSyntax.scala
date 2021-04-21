package me.amuxix.syntax

import me.amuxix.Mergeable

trait MergeableSyntax {
  @inline implicit final def toMergeable[T: Mergeable](t: T): MergeableOps[T] = new MergeableOps(t)
}

class MergeableOps[T](t: T)(implicit M: Mergeable[T]) {
  def canMerge(other: T): Boolean = M.canMerge(t, other)
  def merge(other: T): T = M.merge(t, other)
}