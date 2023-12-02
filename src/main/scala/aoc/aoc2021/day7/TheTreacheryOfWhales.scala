package aoc.aoc2021.day7

import aoc.common.OldAocApp

object TheTreacheryOfWhales extends OldAocApp(2021, 7) {
  override type RT = List[Int]
  override def produceInput(iterator: Iterator[String]): RT = iterator.flatMap(PositionParser.parseLine).toList

  override def partOne(): Unit = {
    val fuelOptimizer = new FuelOptimizer
    println(fuelOptimizer.findMinFuelToUseForConstantFuelRate(input))
  }

  override def partTwo(): Unit = {
    val fuelOptimizer = new FuelOptimizer
    println(fuelOptimizer.findMinFuelToUseForIncreasedFuelRate(input))
  }
}
