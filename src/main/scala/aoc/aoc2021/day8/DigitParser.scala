package aoc.aoc2021.day8

import aoc.aoc2021.day8.Segment.Segment

object DigitParser {

  def parseLine(line: String): Entry = {
    def parseLineAsSegments(line: String): List[Set[Segment]] = {
      line.split(" ")
        .map(_.map(segment => Segment.withName(segment.toUpper.toString)).toSet)
        .toList
    }

    def parseLineAsSignal(line: String): List[Signal] = parseLineAsSegments(line).map(Signal)
    def parseLineAsDisplayedDigits(line: String): List[DisplayedDigit] = parseLineAsSegments(line).map(DigitFactory.createDisplayedDigit)

    val (input, output) = line match {
      case s"$input | $output" => (input, output)
    }

    val signals = parseLineAsSignal(input)
    val digits = parseLineAsDisplayedDigits(output)

    Entry(signals, digits)
  }
}
