package aoc.aoc2021.day2

import scala.io.Source

object Dive extends App {

  val commands = Source.fromFile("src/main/scala/aoc/aoc2021/day2/input.txt")
    .getLines()
    .map(CommandParser.parseString)
    .toList
  println(commands)
  val submarine = new Submarine
  val result = submarine.executeCommands(commands).multipliedCoordinates
  println(result)

  val enhancedSubmarine = new EnhancedSubmarine
  val result2 = enhancedSubmarine.executeCommands(commands).multipliedCoordinates
  println(result2)
}
