package aoc.aoc2023.day1

import aoc.common.util.StringUtils.RichString
import aoc.common.{AocApp, Puzzle}

object Trebuchet extends AocApp(2023, 1) {
  override type IN = List[String]

  override def testModeEnabled = false

  override def produceInput(iterator: Iterator[String]): List[String] = iterator.toList

  override def part1: Puzzle[List[String]] = new Puzzle[List[String]] {
    override type OUT = Int

    override def solve(input: List[String]): Option[Int] = {
      val documentDigits = input.map(_.filter(_.isDigit).map(_.asDigit))
      val calibrationValues = documentDigits.map(d => d.head * 10 + d.last)
      Some(calibrationValues.sum)
    }
  }

  override def part2: Puzzle[List[String]] = new Puzzle[List[String]] {
    override type OUT = Int

    override def solve(input: List[String]): Option[Int] = {
      val documentDigitsAsStrings = input.map(_.extract(Digit.asStrings ::: Digit.asStringNumbers))
      val documentDigits = documentDigitsAsStrings.map(_.map(Digit.numberByString))
      val calibrationValues = documentDigits.map(d => d.head * 10 + d.last)
      Some(calibrationValues.sum)
    }
  }
}
