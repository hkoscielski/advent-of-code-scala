package aoc.common

import aoc.common.util.FileUtils._

import scala.util.{Failure, Success, Try}

abstract class AocApp(year: Int, day: Int) extends App {
  type RT
  def testModeEnabled: Boolean = false
  def produceInput(iterator: Iterator[String]): RT
  def partOne(): Unit
  def partTwo(): Unit

  private val fileName: String = if (testModeEnabled) "test-" else "" + "input.txt"
  private def filePath: String = s"src/main/scala/aoc/aoc$year/day$day/$fileName"

  final val input: RT = open(filePath) { s =>
    Try(s.getLines()) match {
      case Failure(exception) => throw new RuntimeException(s"Error while reading input file: $filePath", exception)
      case Success(value) => produceInput(value)
    }
  }.get

  partOne()
  partTwo()
}
