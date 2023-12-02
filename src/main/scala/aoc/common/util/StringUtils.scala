package aoc.common.util

import scala.annotation.tailrec

object StringUtils {

  implicit class RichString(value: String) {

    def extract(substrings: List[String]): List[String] = {
      @tailrec
      def extract(s: String, acc: List[String]): List[String] = {
        if (s.isEmpty) acc.reverse
        else {
          val prefix = substrings.find(s.startsWith)
          extract(s.substring(1), prefix.map(_ :: acc).getOrElse(acc))
        }
      }

      extract(value, Nil)
    }
  }
}
