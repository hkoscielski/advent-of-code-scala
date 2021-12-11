package aoc.aoc2021.day2

class EnhancedPosition(
  override val depth: Int = 0,
  override val horizontal: Int = 0,
  val aim: Int = 0
) extends Position(depth, horizontal)
