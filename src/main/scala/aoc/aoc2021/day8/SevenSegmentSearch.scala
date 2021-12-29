package aoc.aoc2021.day8

import aoc.common.AocApp

object SevenSegmentSearch extends AocApp {
  override type RT = List[Digit]
  override def filePath: String = "src/main/scala/aoc/aoc2021/day8/input.txt"
  override def produceInput(iterator: Iterator[String]): RT = iterator.flatMap(DigitParser.parseLine).toList

  private def partOne(): Unit = {
    println(input.count(_.hasUniqueNumOfSegments))
  }

  partOne()
}
