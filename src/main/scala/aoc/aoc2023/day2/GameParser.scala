package aoc.aoc2023.day2

object GameParser {

  def parseLine(line: String): Game = {
    val Array(title, statesRaw) = line.split(":")
    val id = parseId(title)
    val states = parseStates(statesRaw)
    Game(id, states)
  }

  private def parseId(title: String) = title.stripPrefix("Game ").toInt

  private def parseStates(statesRaw: String): List[BagState] = {
    val states = statesRaw.split(";").map(_.trim).toList
    states.map(parseState)
  }

  private def parseState(statesRaw: String) = {
    val bag = statesRaw.split(",").map(_.trim)
    val countByColor = bag.map(b => {
      val Array(count, color) = b.split("\\s+")
      color -> count.toInt
    }).toMap
    val reds = countByColor.getOrElse("red", 0)
    val greens = countByColor.getOrElse("green", 0)
    val blues = countByColor.getOrElse("blue", 0)
    BagState(reds, greens, blues)
  }
}
