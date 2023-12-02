package aoc.aoc2023.day2

import aoc.common.{AocApp, Puzzle}

object CubeConundrum extends AocApp(2023, 2) {
  override type IN = List[Game]

  override def produceInput(iterator: Iterator[String]): List[Game] = iterator.map(GameParser.parseLine).toList

  override def part1: Puzzle[List[Game]] = new Puzzle[List[Game]] {
    override type OUT = Int

    override def solve(input: List[Game]): Option[Int] = {
      val filteredGameIds = input.filterNot(_.bagStates.exists(s => s.reds > 12 || s.greens > 13 || s.blues > 14)).map(_.id)
      Some(filteredGameIds.sum)
    }
  }
}
