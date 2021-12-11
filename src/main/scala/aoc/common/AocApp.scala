package aoc.common

import aoc.common.util.FileUtils._

import scala.util.{Failure, Success, Try}

abstract class AocApp extends App {

  type RT
  def filePath: String
  def produceInput(iterator: Iterator[String]): RT

  final val input: RT = open(filePath) { s =>
    Try(s.getLines()) match {
      case Failure(exception) => throw new RuntimeException(s"Error while reading input file: $filePath", exception)
      case Success(value) => produceInput(value)
    }
  }.get
}
