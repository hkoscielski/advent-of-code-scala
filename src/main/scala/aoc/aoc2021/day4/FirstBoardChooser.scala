package aoc.aoc2021.day4

class FirstBoardChooser extends BoardChooser {

  override def getWinningBoard(boards: List[Board]): Option[Board] = Option.when(winningBoardExists(boards)) {
    boards.filter(_.winningOrder.nonEmpty).minBy(_.winningOrder)
  }

  override def winningBoardExists(boards: List[Board]): Boolean = boards.exists(_.isWinning)
}
