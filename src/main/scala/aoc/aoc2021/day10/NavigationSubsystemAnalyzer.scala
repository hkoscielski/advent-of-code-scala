package aoc.aoc2021.day10

import scala.annotation.tailrec

object NavigationSubsystemAnalyzer {
  private val opened = List('(', '[', '{', '<')
  private val closed = List(')', ']', '}', '>')
  private val syntaxErrorScores = List(3, 57, 1197, 25137)
  private val points = Range.inclusive(1, 4).toList
  private val closedByOpened = opened.zip(closed).toMap

  val syntaxErrorScoreByChar: Map[Char, Int] = closed.zip(syntaxErrorScores).toMap
  val pointsByChar: Map[Char, Int] = closed.zip(points).toMap

  def getFirstIllegalCharacter(line: String): Option[Char] = {
    @tailrec
    def getFirstIllegalCharacter(charsToCheck: List[Char], acc: List[Char]): Option[Char] = {
      charsToCheck match {
        case Nil => None
        case h1 :: t1 =>
          acc match {
            case h2 :: t2 if closed.contains(h1) => if (closedByOpened.get(h2).contains(h1)) getFirstIllegalCharacter(t1, t2) else Some(h1)
            case _ => getFirstIllegalCharacter(t1, h1 :: acc)
          }
      }
    }

    getFirstIllegalCharacter(line.toList, Nil)
  }

  def getCompletionString(line: String): Option[String] = {
    @tailrec
    def getCompletionString(charsToCheck: List[Char], acc: List[Char]): String = {
      charsToCheck match {
        case Nil => acc.map(closedByOpened).mkString
        case h1 :: t1 =>
          acc match {
            case h2 :: t2 if closed.contains(h1) && closedByOpened.get(h2).contains(h1) => getCompletionString(t1, t2)
            case _ => getCompletionString(t1, h1 :: acc)
          }
      }
    }

    Option.when(getFirstIllegalCharacter(line).isEmpty)(getCompletionString(line.toList, Nil))
  }
}
