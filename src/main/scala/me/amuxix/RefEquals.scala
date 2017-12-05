package me.amuxix

trait RefEquals extends Writable{
 override def equals(o: Writable): Boolean = this.eq(o)
}
