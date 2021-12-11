package aoc.aoc2021.day5

import aoc.common.AocApp

object HydrothermalVenture extends AocApp {
  override type RT = List[Line]
  override def filePath = "src/main/scala/aoc/aoc2021/day5/input.txt"
  override def produceInput(iterator: Iterator[String]): RT = iterator.map(LineParser.parseLine).toList

  def partOne(): Unit = {
    val axes = input.filter(LineUtils.isAxis)
    val startEndPoints = axes.flatMap(line => List(line.start, line.end))
    val (rows, columns) = (startEndPoints.maxBy(_.x).x + 1, startEndPoints.maxBy(_.y).y + 1)
    val diagram = new Diagram(Array.fill(rows, columns)(None))
    println(diagram.draw(axes).overlappedPoints)
  }

  def partTwo(): Unit = {
    val axesAndDiagonals = input.filter(line => LineUtils.isAxis(line) || LineUtils.isDiagonal(line))
    val startEndPoints = axesAndDiagonals.flatMap(line => List(line.start, line.end))
    val (rows, columns) = (startEndPoints.maxBy(_.x).x + 1, startEndPoints.maxBy(_.y).y + 1)
    val diagram = new Diagram(Array.fill(rows, columns)(None))
    println(diagram.draw(axesAndDiagonals).overlappedPoints)
  }

  partOne()
  partTwo()
}
