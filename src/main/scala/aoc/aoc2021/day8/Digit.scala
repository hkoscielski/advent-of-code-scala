package aoc.aoc2021.day8

import aoc.aoc2021.day8.Segment._

sealed trait Digit {
  def segments: List[Segment]
  def hasUniqueNumOfSegments: Boolean
}
case object Zero extends Digit {
  override val segments: List[Segment] = List(A, B, C, E, F, G)
  override val hasUniqueNumOfSegments: Boolean = false
}
case object One extends Digit {
  override val segments: List[Segment] = List(C, F)
  override val hasUniqueNumOfSegments: Boolean = true
}
case object Two extends Digit {
  override val segments: List[Segment] = List(A, C, D, E, G)
  override val hasUniqueNumOfSegments: Boolean = false
}
case object Three extends Digit {
  override val segments: List[Segment] = List(A, C, D, F, G)
  override val hasUniqueNumOfSegments: Boolean = false
}
case object Four extends Digit {
  override val segments: List[Segment] = List(B, C, D, F)
  override val hasUniqueNumOfSegments: Boolean = true
}
case object Five extends Digit {
  override val segments: List[Segment] = List(A, B, D, F, G)
  override val hasUniqueNumOfSegments: Boolean = false
}
case object Six extends Digit {
  override val segments: List[Segment] = List(A, B, D, E, F, G)
  override val hasUniqueNumOfSegments: Boolean = false
}
case object Seven extends Digit {
  override val segments: List[Segment] = List(A, C, F)
  override val hasUniqueNumOfSegments: Boolean = true
}
case object Eight extends Digit {
  override val segments: List[Segment] = List(A, B, C, D, E, F, G)
  override val hasUniqueNumOfSegments: Boolean = true
}
case object Nine extends Digit {
  override val segments: List[Segment] = List(A, B, C, D, F, G)
  override val hasUniqueNumOfSegments: Boolean = false
}
case class DisplayedDigit(
  segments: List[Segment],
  hasUniqueNumOfSegments: Boolean
) extends Digit

case object DigitFactory {
  private val Digits: List[Digit] = List(Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine)
  private val CountByNumOfSegments: Map[Int, Int] = Digits.map(_.segments.size).groupMapReduce(identity)(_ => 1)(_ + _)

  def createDigit(segments: List[Segment]): Digit = {
    DisplayedDigit(segments, isUnique(segments.size))
  }

  private def isUnique(numOfSegments: Int): Boolean = {
    CountByNumOfSegments.getOrElse(numOfSegments, 1) == 1
  }
}
