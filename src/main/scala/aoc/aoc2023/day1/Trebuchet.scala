package aoc.aoc2023.day1

import aoc.common.{AocApp, Puzzle}

object Trebuchet extends AocApp(2023, 1) {
  override type IN = List[String]

  override def produceInput(iterator: Iterator[String]): List[String] = iterator.toList

  override def part1: Puzzle[List[String]] = new Puzzle[List[String]] {
    override type OUT = Int

    override def solve(input: List[String]): Option[Int] = {
      val documentDigits = input.map(_.filter(_.isDigit))
      val calibrationValues = documentDigits.map(d => d.head.asDigit * 10 + d.last.asDigit)
      Some(calibrationValues.sum)
    }
  }
}
