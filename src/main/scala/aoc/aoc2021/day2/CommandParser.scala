package aoc.aoc2021.day2

object CommandParser {

  def parseString(line: String): Command = {
    val splittedLine = line.split("\\s")
    val command = splittedLine(0)
    val value = splittedLine(1).toInt

    CommandFactory.createCommand(command, value)
  }
}
