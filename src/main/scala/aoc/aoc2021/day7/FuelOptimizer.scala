package aoc.aoc2021.day7

class FuelOptimizer {

  def findMinFuelToUseForConstantFuelRate(positions: List[Int]): Int = {
    val (min, max) = (positions.min, positions.max)
    (min to max).map(position => positions.map(p => (p - position).abs).sum).min
  }

  def findMinFuelToUseForIncreasedFuelRate(positions: List[Int]): Int = {
    val (min, max) = (positions.min, positions.max)
    (min to max).map(position => positions.map(p => {
      val units = (p - position).abs
      (1 + units) * units / 2
    }).sum).min
  }
}
