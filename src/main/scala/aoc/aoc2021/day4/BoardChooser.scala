package aoc.aoc2021.day4

trait BoardChooser {

  def getWinningBoard(boards: List[Board]): Option[Board]
  def winningBoardExists(boards: List[Board]): Boolean
}
