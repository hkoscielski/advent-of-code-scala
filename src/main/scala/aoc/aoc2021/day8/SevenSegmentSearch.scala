package aoc.aoc2021.day8

import aoc.common.AocApp

object SevenSegmentSearch extends AocApp(2021, 8) {
  override type RT = List[Entry]
  override def produceInput(iterator: Iterator[String]): List[Entry] = iterator.map(DigitParser.parseLine).toList

  override def partOne(): Unit = {
    println(input.flatMap(_.displayedDigits).count(_.hasUniqueNumOfSegments))
  }

  override def partTwo(): Unit = {
    val sum = input.map { e =>
      val mapping = DigitFactory.produceDigitMapping(e.signals)
      val outputDigits = e.displayedDigits.map(mapping)
      DigitFactory.decodeValue(outputDigits)
    }.sum
    println(sum)
  }
}
