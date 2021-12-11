package aoc.aoc2021.day4

class Board(cells: Array[Array[Cell]], val winningOrder: Option[Int]) {

  private val rows = cells.length
  private val columns = {
    val columnDistinctLengths = cells.map(_.length).distinct
    if (columnDistinctLengths.length != 1 || columnDistinctLengths.head != rows) throw new IllegalArgumentException("Rows and columns are not equal in board")
    columnDistinctLengths.head
  }

  def markCells(number: Int): Board = {
    val boardWithMarkedCells = cells.map {
      row => row.map { cell => if (!cell.isMarked && number == cell.value) Cell(cell.value, isMarked = true) else cell }
    }

    new Board(boardWithMarkedCells, winningOrder)
  }

  def assignWinningOrder(winningOrder: Int): Board = {
    if (this.winningOrder.isEmpty && isWinning) new Board(cells, Some(winningOrder)) else this
  }

  def isWinning: Boolean = {
    def isRowWinning(cells: Array[Array[Cell]]): Boolean =
      cells.map(row => row.map(_.isMarked)).exists(row => row.forall(identity))

    isRowWinning(cells) || isRowWinning(cells.transpose)
  }

  def unmarkedSum: Int = cells.map(_.filter(!_.isMarked).map(_.value).sum).sum

  override def toString: String = {
    val str = for (l <- cells) yield l.mkString("\t[ ", ", ", " ]")
    str.mkString("{\n",",\n","\n}")
  }
}
