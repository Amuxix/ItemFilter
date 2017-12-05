package me.amuxix

trait ValueEquals extends Writable {
  override def equals(o: Writable): Boolean = this.eq(o)
}
