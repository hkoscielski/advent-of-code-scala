package aoc.common.util

import scala.io.{BufferedSource, Source}
import scala.util.{Try, Using}

object FileUtils {
  def open[T](path: String): (BufferedSource => T) => Try[T] = Using(Source.fromFile(path))
}
