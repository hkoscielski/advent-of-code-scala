package aoc.aoc2021.day9

import aoc.common.AocApp

object SmokeBasin extends AocApp {
  override type RT = Heightmap
  override def filePath = "src/main/scala/aoc/aoc2021/day9/input.txt"
  override def produceInput(iterator: Iterator[String]): Heightmap = Heightmap(iterator.map(HeightmapParser.parseLine).toList)

  private def partOne(): Unit = {
    val riskLevels = input.lowPoints.map(_ + 1)
    println(riskLevels.sum)
  }

  partOne()
}
