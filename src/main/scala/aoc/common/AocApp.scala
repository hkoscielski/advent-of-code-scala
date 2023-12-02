package aoc.common

import aoc.common.util.FileUtils._

import scala.util.{Failure, Success, Try}

abstract class AocApp(year: Int, day: Int) extends App {
  type IN
  def testModeEnabled: Boolean = false
  def produceInput(iterator: Iterator[String]): IN

  def part1: Puzzle[IN]
  def part2: Puzzle[IN] = new Puzzle[IN] {
    override type OUT = this.type
  }

  private final val fileName: String = (if (testModeEnabled) "test-" else "") + "input.txt"
  private def filePath: String = s"src/main/scala/aoc/aoc$year/day$day/$fileName"

  private final val input: IN = open(filePath) { s =>
    Try(s.getLines()) match {
      case Failure(exception) => throw new RuntimeException(s"Error while reading input file: $filePath", exception)
      case Success(value) => produceInput(value)
    }
  }.get

  private[this] val puzzle1 = part1
  private[this] val puzzle2 = part2
  private[this] val separator = LazyList.continually("*").take(50).mkString
  println(separator)
  println(s"Advent of Code $year - Day $day")
  for {
    (puzzle, i) <- List(puzzle1, puzzle2).zip(LazyList.from(1))
  } {
    println(separator)
    println(s"Puzzle $i:")
    println(s"Solution: ${puzzle.solve(input).map(puzzle.formatSolution).getOrElse("Not solved yet!")}")
  }
  println(separator)
}
