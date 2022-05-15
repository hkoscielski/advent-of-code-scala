package aoc.aoc2021.day4

import aoc.common.AocApp

object GiantSquid extends AocApp(2021, 4) {
  override type RT = (List[Int], List[Board])
  override def produceInput(iterator: Iterator[String]): (List[Int], List[Board]) = BingoParser.parseLines(iterator.toList)

  override def partOne(): Unit = {
    val (bingoSubsystem, boards) = input
    val bingo = new Bingo(boards, new FirstBoardChooser)
    val (finishedBingo, lastNumber) = bingo.play(bingoSubsystem)
    println(finishedBingo.getWinningBoard.foreach(b => println(b.unmarkedSum * lastNumber)))
  }

  override def partTwo(): Unit = {
    val (bingoSubsystem, boards) = input
    val bingo2 = new Bingo(boards, new LastBoardChooser)
    val (finishedBingo2, lastNumber2) = bingo2.play(bingoSubsystem)
    println(finishedBingo2.getWinningBoard.foreach(b => println(b.unmarkedSum * lastNumber2)))
  }
}
