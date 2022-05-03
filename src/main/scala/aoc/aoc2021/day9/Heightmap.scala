package aoc.aoc2021.day9

import scala.annotation.tailrec

case class Heightmap(grid: List[List[Int]]) {
  private[this] val rows = grid.length
  private[this] val columns = {
    val columnDistinctLengths = grid.map(_.length).distinct
    if (columnDistinctLengths.length != 1) throw new IllegalArgumentException("Heightmap is not reqular!")
    columnDistinctLengths.head
  }

  case class Position(row: Int, column: Int)
  case class Location(position: Position, height: Int)
  type Basin = Set[Location]

  def basins: List[Basin] = {
    @tailrec
    def findBasin(visitedPositions: Set[Position], locationsToVisit: List[Location], acc: Set[Location]): Basin = {
      locationsToVisit match {
        case Nil => acc
        case h :: t =>
          val positions = neighbourPositions(h.position)
          val nextBasinLocations = positions
            .map(p => Location(p, grid(p.row)(p.column)))
            .filter(l => !visitedPositions(l.position) && l.height != 9)
          findBasin(visitedPositions + h.position, t ::: nextBasinLocations, acc ++ nextBasinLocations)
      }
    }

    lowPoints.map(lp => findBasin(Set.empty, lp :: Nil, Set(lp)))
  }

  def lowPoints: List[Location] = {
    for {
      i <- List.range(0, rows)
      j <- List.range(0, columns)
      position = Position(i, j)
      if isLowPoint(position)
    } yield Location(position, grid(i)(j))
  }

  private[this] def isLowPoint(position: Position): Boolean = {
    val neighbourHeights = neighbourPositions(position).map(n => grid(n.row)(n.column))
    grid(position.row)(position.column) < neighbourHeights.min
  }

  private[this] def neighbourPositions(position: Position): List[Position] = {
    List(
      Option.when(position.column > 0)(Position(position.row, position.column - 1)),
      Option.when(position.row > 0)(Position(position.row - 1, position.column)),
      Option.when(position.column < columns - 1)(Position(position.row, position.column + 1)),
      Option.when(position.row < rows - 1)(Position(position.row + 1, position.column))
    ).flatten
  }
}
