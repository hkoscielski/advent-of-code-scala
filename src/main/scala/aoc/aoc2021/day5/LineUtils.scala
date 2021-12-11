package aoc.aoc2021.day5

import aoc.common.util.NumberUtils.RichDouble

object LineUtils {

  def isAxis(line: Line): Boolean =
    line.start.x == line.end.x || line.start.y == line.end.y

  def isDiagonal(line: Line): Boolean = {
    def legLength(start: Point, end: Point): Double = {
      Math.sqrt(Math.pow(end.x - start.x, 2) + Math.pow(end.y - start.y, 2))
    }

    val thirdTrianglePoint = Point(line.end.x, line.start.y)
    val hypotenuse = legLength(line.start, line.end)
    val firstLeg = legLength(line.start, thirdTrianglePoint)
    val secondLeg = legLength(line.end, thirdTrianglePoint)

    (firstLeg ~= secondLeg) && (firstLeg * Math.sqrt(2) ~= hypotenuse)
  }
}
