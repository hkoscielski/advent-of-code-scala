package aoc.aoc2021.day4

import scala.annotation.tailrec

class Bingo(val boards: List[Board], boardChooser: BoardChooser) {

  def play(subsystem: List[Int]): (Bingo, Int) = {
    @tailrec
    def play(subsystem: List[Int], acc1: Bingo, acc2: Int): (Bingo, Int) = {
      if (subsystem.size <= 0 || boardChooser.winningBoardExists(acc1.boards)) (acc1, acc2)
      else {
        val number = subsystem.head
        val markedBoards = acc1.boards.map(_.markCells(number))
        val nextWinningOrder = getNextWinningOrder(markedBoards)
        val assignedMarkedBoards = markedBoards.zipWithIndex.map { case (b, i) => b.assignWinningOrder(nextWinningOrder + i) }
        play(subsystem.tail, new Bingo(assignedMarkedBoards, boardChooser), number)
      }
    }

    play(subsystem, this, 0)
  }

  def getWinningBoard: Option[Board] = boardChooser.getWinningBoard(boards)
  private def getNextWinningOrder(boards: List[Board]): Int = boards.filter(_.winningOrder.nonEmpty)
    .maxByOption(_.winningOrder)
    .flatMap(_.winningOrder)
    .getOrElse(1)
}