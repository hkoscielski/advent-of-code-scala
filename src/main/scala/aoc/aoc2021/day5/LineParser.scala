package aoc.aoc2021.day5

object LineParser {

  def parseLine(line: String): Line = {
    def parseLineAsPoint(line: String): Point = line match {
      case s"$x,$y" => Point(x.toInt, y.toInt)
      case _ => throw new IllegalArgumentException(s"Cannot parse line as point. Found: $line")
    }

    val (rawStart, rawEnd) = line match {
      case s"$start -> $end" => (start, end)
      case _ => throw new IllegalArgumentException(s"Cannot parse line. Found: $line")
    }
    val start = parseLineAsPoint(rawStart)
    val end = parseLineAsPoint(rawEnd)

    Line(start, end)
  }
}
