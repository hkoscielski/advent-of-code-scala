package aoc.aoc2021.day9

import aoc.common.AocApp

object SmokeBasin extends AocApp {
  override type RT = Heightmap
  override def filePath = "src/main/scala/aoc/aoc2021/day9/input.txt"
  override def produceInput(iterator: Iterator[String]): Heightmap = Heightmap(iterator.map(HeightmapParser.parseLine).toList)

  private def partOne(): Unit = {
    val riskLevels = input.lowPoints.map(_.height + 1)
    println(riskLevels.sum)
  }

  private def partTwo(): Unit = {
    val threeLargestBasinSizes = input.basins
      .map(_.size)
      .sorted(Ordering[Int].reverse)
      .take(3)
    println(threeLargestBasinSizes.product)
  }

  partOne()
  partTwo()
}
