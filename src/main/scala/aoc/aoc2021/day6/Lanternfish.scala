package aoc.aoc2021.day6

import aoc.common.OldAocApp

object Lanternfish extends OldAocApp(2021, 6) {
  override type RT = List[Long]
  override def produceInput(iterator: Iterator[String]): RT = iterator.flatMap(LanternfishParser.parseLine).toList

  override def partOne(): Unit = {
    val simulator = new LanternfishSimulator
    println(simulator.simulate(input, 80))
  }

  override def partTwo(): Unit = {
    val simulator = new LanternfishSimulator
    println(simulator.simulate(input, 256))
  }
}
