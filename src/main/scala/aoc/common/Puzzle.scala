package aoc.common

abstract class Puzzle[IN] {
  type OUT

  def solve(input: IN): Option[OUT] = None

  def formatSolution(solution: OUT): String = solution.toString
}
