package me.amuxix

trait Writer[-T] {
  def write(thing: T): String
}

object Writer {
  implicit class writerSyntax[T](thing: T)(implicit T: Writer[T]) {
    def write: String = T.write(thing)
  }

  implicit def nonWriter[T: Writer]: Writer[Option[T]] = _.fold("")(_.write)
}
