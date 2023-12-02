package aoc.aoc2021.day9

import aoc.common.OldAocApp

object SmokeBasin extends OldAocApp(2021, 9) {
  override type RT = Heightmap
  override def produceInput(iterator: Iterator[String]): Heightmap = Heightmap(iterator.map(HeightmapParser.parseLine).toList)

  override def partOne(): Unit = {
    val riskLevels = input.lowPoints.map(_.height + 1)
    println(riskLevels.sum)
  }

  override def partTwo(): Unit = {
    val threeLargestBasinSizes = input.basins
      .map(_.size)
      .sorted(Ordering[Int].reverse)
      .take(3)
    println(threeLargestBasinSizes.product)
  }
}
