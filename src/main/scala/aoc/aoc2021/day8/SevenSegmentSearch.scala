package aoc.aoc2021.day8

import aoc.common.AocApp

object SevenSegmentSearch extends AocApp {
  override type RT = List[Entry]
  override def filePath: String = "src/main/scala/aoc/aoc2021/day8/input.txt"
  override def produceInput(iterator: Iterator[String]): List[Entry] = iterator.map(DigitParser.parseLine).toList

  private def partOne(): Unit = {
    println(input.flatMap(_.displayedDigits).count(_.hasUniqueNumOfSegments))
  }

  private def partTwo(): Unit = {
    val sum = input.map { e =>
      val mapping = DigitFactory.produceDigitMapping(e.signals)
      val outputDigits = e.displayedDigits.map(mapping)
      DigitFactory.decodeValue(outputDigits)
    }.sum
    println(sum)
  }

  partOne()
  partTwo()
}
