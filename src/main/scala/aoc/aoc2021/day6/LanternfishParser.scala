package aoc.aoc2021.day6

object LanternfishParser {

  def parseLine(line: String): List[Long] = {
    line.split(",").map(_.toLong).toList
  }
}
