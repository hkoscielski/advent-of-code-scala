package aoc.aoc2021.day4

import aoc.common.AocApp

object GiantSquid extends AocApp {
  override type RT = List[String]
  override def filePath = "src/main/scala/aoc/aoc2021/day4/input.txt"
  override def produceInput(iterator: Iterator[String]): List[String] = iterator.toList

  val (bingoSubsystem, boards) = BingoParser.parseLines(input)

  val bingo = new Bingo(boards, new FirstBoardChooser)
  val (finishedBingo, lastNumber) = bingo.play(bingoSubsystem)
  println(finishedBingo.getWinningBoard.foreach(b => println(b.unmarkedSum * lastNumber)))

  val bingo2 = new Bingo(boards, new LastBoardChooser)
  val (finishedBingo2, lastNumber2) = bingo2.play(bingoSubsystem)
  println(finishedBingo2.getWinningBoard.foreach(b => println(b.unmarkedSum * lastNumber2)))
}
