package aoc.aoc2021.day6

import aoc.aoc2021.day6.LanternfishSimulator.{AgeAfterReset, NewAge}

import scala.annotation.tailrec
import scala.collection.immutable.ListMap

class LanternfishSimulator {

  def simulate(ages: List[Long], days: Int): Long = {
    @tailrec
    def simulate(ages: Map[Int, Long], remainingDays: Int): Long = {
      if (remainingDays <= 0) ages.values.sum
      else {
        val newElementsCount = ages.getOrElse(0, 0L)
        val newAges = ListMap.from(ages.toSeq.sortBy(_._1)).map { case (k, v) => (k - 1, v) }
        val resettedNewAges = newAges + (AgeAfterReset -> (newAges.getOrElse(-1, 0L) + newAges.getOrElse(AgeAfterReset, 0L)))
        val newAgesWithNewLanternfishes = resettedNewAges + (NewAge -> (resettedNewAges.getOrElse(NewAge, 0L) + newElementsCount))
        val filteredAges = newAgesWithNewLanternfishes.filter { case (k, v) => k >= 0 && v != 0L }
        simulate(filteredAges, remainingDays - 1)
      }
    }

    simulate(ages.groupBy(identity).map { case (k, v) => (k.toInt, v.size) }, days)
  }
}

object LanternfishSimulator {
  val AgeAfterReset = 6
  val NewAge = 8
}