package aoc.aoc2023.day2

case class Game(id: Int, bagStates: List[BagState])
case class BagState(reds: Int, greens: Int, blues: Int) {
  def power: Long = reds * greens * blues
  def applyMax(other: BagState): BagState = BagState(Math.max(reds, other.reds), Math.max(greens, other.greens), Math.max(blues, other.blues))
}
object BagState {
  val empty: BagState = BagState(0, 0, 0)
}
