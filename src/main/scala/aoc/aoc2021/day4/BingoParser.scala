package aoc.aoc2021.day4

import aoc.common.util.CollectionUtils._

object BingoParser {

  def parseLines(lines: List[String]): (List[Int], List[Board]) = {
    val (bingoSubsystemRaw, boardsRaw) = lines match {
      case bingoSubsystemRaw :: "" :: boardsRaw => (bingoSubsystemRaw, boardsRaw)
    }

    val bingoSubsystem = bingoSubsystemRaw.split(",").map(_.toInt).toList
    val boards = boardsRaw.splitWhen(_ == "")
      .map(_.map(_.trim.split("\\s+").map(value => Cell(value.toInt))).toArray)
      .map(matrix => new Board(matrix, None))

    (bingoSubsystem, boards)
  }
}
