package aoc.aoc2021.day6

import aoc.common.AocApp

object Lanternfish extends AocApp {
  override type RT = List[Long]
  override def filePath: String = "src/main/scala/aoc/aoc2021/day6/input.txt"
  override def produceInput(iterator: Iterator[String]): RT = iterator.flatMap(LanternfishParser.parseLine).toList

  private def partOne(): Unit = {
    val simulator = new LanternfishSimulator
    println(simulator.simulate(input, 80))
  }

  private def partTwo(): Unit = {
    val simulator = new LanternfishSimulator
    println(simulator.simulate(input, 256))
  }

  partOne()
  partTwo()
}
