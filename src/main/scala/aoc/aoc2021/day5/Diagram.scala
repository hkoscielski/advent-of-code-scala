package aoc.aoc2021.day5

class Diagram(drawnLines: Array[Array[Option[Int]]] = Array.empty) {

  def draw(lines: List[Line]): Diagram = {
    for {
      line <- lines
      points = line.points
      point <- points
    } drawnLines(point.x)(point.y) = drawnLines(point.x)(point.y).map(_ + 1).orElse(Some(1))

    new Diagram(drawnLines)
  }

  def overlappedPoints: Int = {
    val overlapped = for {
      row <- drawnLines
      optPoint <- row
      point <- optPoint if point > 1
    } yield point

    overlapped.length
  }

  override def toString: String = {
    val str = for (l <- drawnLines.transpose) yield l.mkString("\t[ ", ", ", " ]")
    str.mkString("{\n",",\n","\n}")
  }
}
