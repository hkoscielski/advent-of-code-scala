package aoc.aoc2021.day8

object DigitParser {

  def parseLine(line: String): List[Digit] = {
    val splittedInputOutput = line.split(" \\| ")
    val output = splittedInputOutput(1)

    output.split(" ")
      .map(_.map(segment => Segment.withName(segment.toUpper.toString)).toList)
      .map(DigitFactory.createDigit)
      .toList
  }
}
