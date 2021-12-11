package aoc.aoc2021.day4

class LastBoardChooser extends BoardChooser {

  override def getWinningBoard(boards: List[Board]): Option[Board] = Option.when(winningBoardExists(boards)) {
    boards.filter(_.winningOrder.nonEmpty).maxBy(_.winningOrder)
  }

  override def winningBoardExists(boards: List[Board]): Boolean = boards.forall(_.isWinning)
}
