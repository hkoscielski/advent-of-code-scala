package aoc.aoc2021.day7

object PositionParser {

  def parseLine(line: String): List[Int] = {
    line.split(",").map(_.toInt).toList
  }
}
