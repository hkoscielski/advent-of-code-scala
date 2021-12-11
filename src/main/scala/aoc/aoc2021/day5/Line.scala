package aoc.aoc2021.day5

import aoc.common.util.CollectionUtils.RichList
import aoc.common.util.NumberUtils

case class Line(start: Point, end: Point) {

  def points: List[Point] = {
    val lowerX = Integer.min(start.x, end.x)
    val upperX = Integer.max(start.x, end.x)
    val lowerY = Integer.min(start.y, end.y)
    val upperY = Integer.max(start.y, end.y)

    val xCoordsUnique = (lowerX to upperX).toList.reverseIf(lowerX != start.x)
    val yCoordsUnique = (lowerY to upperY).toList.reverseIf(lowerY != start.y)

    val gdc = NumberUtils.gcd(xCoordsUnique.size, yCoordsUnique.size)
    val xMultiplier = yCoordsUnique.size / gdc
    val yMultiplier = xCoordsUnique.size / gdc
    val xCoords = xCoordsUnique.times(xMultiplier)
    val yCoords = yCoordsUnique.times(yMultiplier)

    xCoords.zip(yCoords).map { case (x, y) => Point(x, y) }
  }
}
