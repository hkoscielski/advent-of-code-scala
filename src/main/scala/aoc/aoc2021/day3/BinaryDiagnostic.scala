package aoc.aoc2021.day3

import scala.annotation.tailrec
import scala.io.Source

object BinaryDiagnostic extends App {

  val reportLines = Source.fromFile("src/main/scala/aoc/aoc2021/day3/input.txt")
    .getLines()
    .toList
    .map(_.toList)
  val valuesPerPosition = reportLines.transpose
  val groupedValuesPerPosition = valuesPerPosition.map(_.groupBy(identity))
  val gammaRate = Integer.parseInt(groupedValuesPerPosition.map(_.maxBy(_._2.size)._1).mkString, 2)
  val epsilonRate = Integer.parseInt(groupedValuesPerPosition.map(_.minBy(_._2.size)._1).mkString, 2)
  println(gammaRate * epsilonRate)
  // 3277364

  def oxygenGeneratorRating(lines: List[List[Char]], groupedValuesPerPosition: List[Map[Char, List[Char]]]): Int = {
    @tailrec
    def oxygenGeneratorRating(lines: List[List[Char]], groupedValuesPerPosition: List[Map[Char, List[Char]]], bitPosition: Int): Int = {
      lines match {
        case head :: Nil => Integer.parseInt(head.mkString, 2)
        case _ :: _ => {
          val filteredLines = lines.filter(l => l(bitPosition) == groupedValuesPerPosition.map(_.maxBy { case (k, v) => (v.size, k.toString.toInt) }._1)(bitPosition))
          val filteredGroupedValuedPerPosition = filteredLines.transpose.map(_.groupBy(identity))
          oxygenGeneratorRating(filteredLines, filteredGroupedValuedPerPosition, bitPosition + 1)
        }
      }
    }

    oxygenGeneratorRating(lines, groupedValuesPerPosition, 0)
  }

  def co2ScrubberRating(lines: List[List[Char]], groupedValuesPerPosition: List[Map[Char, List[Char]]]): Int = {
    @tailrec
    def co2ScrubberRating(lines: List[List[Char]], groupedValuesPerPosition: List[Map[Char, List[Char]]], bitPosition: Int): Int = {
      lines match {
        case head :: Nil => Integer.parseInt(head.mkString, 2)
        case _ :: _ => {
          val filteredLines = lines.filter(l => l(bitPosition) == groupedValuesPerPosition.map(_.minBy { case (k, v) => (v.size, k.toString.toInt) }._1)(bitPosition))
          val filteredGroupedValuedPerPosition = filteredLines.transpose.map(_.groupBy(identity))
          co2ScrubberRating(filteredLines, filteredGroupedValuedPerPosition, bitPosition + 1)
        }
      }
    }

    co2ScrubberRating(lines, groupedValuesPerPosition, 0)
  }

  val oxygen = oxygenGeneratorRating(reportLines, groupedValuesPerPosition)
  val co2 = co2ScrubberRating(reportLines, groupedValuesPerPosition)
  println(oxygen * co2)
  // 5736383
}
