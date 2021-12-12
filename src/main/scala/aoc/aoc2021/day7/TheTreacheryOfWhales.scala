package aoc.aoc2021.day7

import aoc.common.AocApp

object TheTreacheryOfWhales extends AocApp {
  override type RT = List[Int]
  override def filePath = "src/main/scala/aoc/aoc2021/day7/input.txt"
  override def produceInput(iterator: Iterator[String]): RT = iterator.flatMap(PositionParser.parseLine).toList

  private def partOne(): Unit = {
    val fuelOptimizer = new FuelOptimizer
    println(fuelOptimizer.findMinFuelToUseForConstantFuelRate(input))
  }

  private def partTwo(): Unit = {
    val fuelOptimizer = new FuelOptimizer
    println(fuelOptimizer.findMinFuelToUseForIncreasedFuelRate(input))
  }

  partOne()
  partTwo()
}
