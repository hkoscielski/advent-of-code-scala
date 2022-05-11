package aoc.aoc2021.day10

import scala.annotation.tailrec

object NavigationSubsystemAnalyzer {
  private val opened = List('(', '[', '{', '<')
  private val closed = List(')', ']', '}', '>')
  private val syntaxErrorScores = List(3, 57, 1197, 25137)
  private val closedByOpened = opened.zip(closed).toMap

  val syntaxErrorScoreByChar: Map[Char, Int] = closed.zip(syntaxErrorScores).toMap

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
}
