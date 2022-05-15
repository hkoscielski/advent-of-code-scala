package aoc.aoc2021.day10

import aoc.common.AocApp

object SyntaxScoring extends AocApp(2021, 10) {
  override type RT = List[String]
  override def produceInput(iterator: Iterator[String]): List[String] = iterator.toList

  override def partOne(): Unit = {
    val firstIllegalCharacters = input.flatMap(NavigationSubsystemAnalyzer.getFirstIllegalCharacter)
    val sum = firstIllegalCharacters.map(NavigationSubsystemAnalyzer.syntaxErrorScoreByChar).sum
    println(sum)
  }

  override def partTwo(): Unit = {
    val completionStrings: List[String] = input.flatMap(NavigationSubsystemAnalyzer.getCompletionString)
    val totalScores = completionStrings.map(cs => cs.foldLeft(0L)((acc, c) => acc * 5 + NavigationSubsystemAnalyzer.pointsByChar(c))).sorted
    val middle = totalScores(totalScores.size / 2)
    println(middle)
  }
}
