package aoc.aoc2021.day1

import scala.io.Source

object SonarSweep extends App {

  val input = Source.fromFile("src/main/scala/aoc/aoc2021/day1/input.txt").getLines().map(_.toInt).toList
  println(input)
  val result = input.zip(input.tail).count{ case (a, b) => a < b }
  val sumOfThree = input.sliding(3).map(_.sum).toList
  val result2 = sumOfThree.zip(sumOfThree.tail).count { case (a, b) => a < b }
  println(result)
  println(result2)
}
