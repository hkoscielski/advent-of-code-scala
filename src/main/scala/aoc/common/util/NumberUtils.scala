package aoc.common.util

import scala.annotation.tailrec

object NumberUtils {

  @tailrec
  def gcd(a: Int, b: Int): Int = b match {
    case 0 => a
    case _ => gcd(b, a % b)
  }

  implicit class RichDouble(x: Double) {

    def ~=(y: Double, precision: Double = 0.00000001): Boolean = {
      (x - y).abs < precision
    }
  }
}
