package aoc.aoc2021.day10

import aoc.common.AocApp

object SyntaxScoring extends AocApp {
  override type RT = List[String]
  override def filePath = "src/main/scala/aoc/aoc2021/day10/input.txt"
  override def produceInput(iterator: Iterator[String]): List[String] = iterator.toList

  private def partOne(): Unit = {
    val firstIllegalCharacters = input.flatMap(NavigationSubsystemAnalyzer.getFirstIllegalCharacter)
    val sum = firstIllegalCharacters.map(NavigationSubsystemAnalyzer.syntaxErrorScoreByChar).sum
    println(sum)
  }

  partOne()
}
