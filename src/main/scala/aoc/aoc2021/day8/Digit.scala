package aoc.aoc2021.day8

import aoc.aoc2021.day8.Segment._

import scala.annotation.tailrec
import scala.collection.immutable.Set

sealed trait Digit {
  def segments: Set[Segment]
  def hasUniqueNumOfSegments: Boolean
}
abstract class PredefinedDigit extends Digit {
  def value: Byte
}
case object Zero extends PredefinedDigit {
  override val segments: Set[Segment] = Set(A, B, C, E, F, G)
  override val hasUniqueNumOfSegments: Boolean = false
  override val value: Byte = 0
}
case object One extends PredefinedDigit {
  override val segments: Set[Segment] = Set(C, F)
  override val hasUniqueNumOfSegments: Boolean = true
  override val value: Byte = 1
}
case object Two extends PredefinedDigit {
  override val segments: Set[Segment] = Set(A, C, D, E, G)
  override val hasUniqueNumOfSegments: Boolean = false
  override val value: Byte = 2
}
case object Three extends PredefinedDigit {
  override val segments: Set[Segment] = Set(A, C, D, F, G)
  override val hasUniqueNumOfSegments: Boolean = false
  override val value: Byte = 3
}
case object Four extends PredefinedDigit {
  override val segments: Set[Segment] = Set(B, C, D, F)
  override val hasUniqueNumOfSegments: Boolean = true
  override val value: Byte = 4
}
case object Five extends PredefinedDigit {
  override val segments: Set[Segment] = Set(A, B, D, F, G)
  override val hasUniqueNumOfSegments: Boolean = false
  override val value: Byte = 5
}
case object Six extends PredefinedDigit {
  override val segments: Set[Segment] = Set(A, B, D, E, F, G)
  override val hasUniqueNumOfSegments: Boolean = false
  override val value: Byte = 6
}
case object Seven extends PredefinedDigit {
  override val segments: Set[Segment] = Set(A, C, F)
  override val hasUniqueNumOfSegments: Boolean = true
  override val value: Byte = 7
}
case object Eight extends PredefinedDigit {
  override val segments: Set[Segment] = Set(A, B, C, D, E, F, G)
  override val hasUniqueNumOfSegments: Boolean = true
  override val value: Byte = 8
}
case object Nine extends PredefinedDigit {
  override val segments: Set[Segment] = Set(A, B, C, D, F, G)
  override val hasUniqueNumOfSegments: Boolean = false
  override val value: Byte = 9
}
case class DisplayedDigit(
  segments: Set[Segment],
  hasUniqueNumOfSegments: Boolean
) extends Digit

case object DigitFactory {
  val Digits: List[PredefinedDigit] = List(Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine)
  private val CountByNumOfSegments: Map[Int, Int] = Digits.map(_.segments.size).groupMapReduce(identity)(_ => 1)(_ + _)

  def createDisplayedDigit(segments: Set[Segment]): DisplayedDigit = {
    def isUnique(numOfSegments: Int): Boolean = CountByNumOfSegments.getOrElse(numOfSegments, 1) == 1

    DisplayedDigit(segments, isUnique(segments.size))
  }

  def produceDigitMapping(signals: List[Signal]): Map[DisplayedDigit, PredefinedDigit] = {
    def findDisplayedDigitByUnique(numOfSegments: Int): DisplayedDigit = {
      signals.filter(_.pattern.size == numOfSegments) match {
        case h :: Nil => createDisplayedDigit(h.pattern)
        case _ => throw new RuntimeException("Non unique number of segments: " + numOfSegments)
      }
    }

    def findDisplayedDigitBySegments(signals: List[Signal], segments: Set[Segment]): (DisplayedDigit, List[Signal]) = {
      val (result :: Nil, remainingSignals) = signals.partition(s => segments.subsetOf(s.pattern))
      (createDisplayedDigit(result.pattern), remainingSignals)
    }

    val one = findDisplayedDigitByUnique(One.segments.size)
    val four = findDisplayedDigitByUnique(Four.segments.size)
    val seven = findDisplayedDigitByUnique(Seven.segments.size)
    val eight = findDisplayedDigitByUnique(Eight.segments.size)

    val fivefoldSignals = signals.filter(_.pattern.size == 5)
    val (three, remainingFivefoldSignals) = findDisplayedDigitBySegments(fivefoldSignals, one.segments)
    val (five, signalForTwo :: Nil) = findDisplayedDigitBySegments(remainingFivefoldSignals, four.segments &~ one.segments)
    val two = createDisplayedDigit(signalForTwo.pattern)

    val sixfoldSignals = signals.filter(_.pattern.size == 6)
    val (nine, remainingSixfoldSignals) = findDisplayedDigitBySegments(sixfoldSignals, three.segments)
    val (zero, signalForSix :: Nil) = findDisplayedDigitBySegments(remainingSixfoldSignals, seven.segments)
    val six = createDisplayedDigit(signalForSix.pattern)

    List(zero, one, two, three, four, five, six, seven, eight, nine).zip(Digits).toMap
  }

  def decodeValue(digits: List[PredefinedDigit]): Int = {
    @tailrec
    def decodeValue(digits: List[PredefinedDigit], value: Int): Int = {
      digits match {
        case Nil => value
        case h :: t => decodeValue(t, Math.pow(10, t.size).intValue * h.value + value)
      }
    }

    decodeValue(digits, 0)
  }
}
