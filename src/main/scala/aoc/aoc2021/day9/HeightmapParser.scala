package aoc.aoc2021.day9

object HeightmapParser {

  def parseLine(line: String): List[Int] = line.map(_.asDigit).toList
}
