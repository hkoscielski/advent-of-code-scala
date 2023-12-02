package aoc.aoc2023.day1

import enumeratum.{Enum, EnumEntry}

sealed trait Digit extends EnumEntry {
  val asString: String
  val asNumber: Int
}

object Digit extends Enum[Digit] {
  case object One extends Digit {
    override val asString: String = "one"
    override val asNumber: Int = 1
  }

  case object Two extends Digit {
    override val asString: String = "two"
    override val asNumber: Int = 2
  }

  case object Three extends Digit {
    override val asString: String = "three"
    override val asNumber: Int = 3
  }

  case object Four extends Digit {
    override val asString: String = "four"
    override val asNumber: Int = 4
  }

  case object Five extends Digit {
    override val asString: String = "five"
    override val asNumber: Int = 5
  }

  case object Six extends Digit {
    override val asString: String = "six"
    override val asNumber: Int = 6
  }

  case object Seven extends Digit {
    override val asString: String = "seven"
    override val asNumber: Int = 7
  }

  case object Eight extends Digit {
    override val asString: String = "eight"
    override val asNumber: Int = 8
  }

  case object Nine extends Digit {
    override val asString: String = "nine"
    override val asNumber: Int = 9
  }

  override def values: IndexedSeq[Digit] = findValues

  lazy val asStrings: List[String] = values.map(_.asString).toList
  lazy val asStringNumbers: List[String] = values.map(_.asNumber.toString).toList
  lazy val numberByString: Map[String, Int] = values.flatMap(v => Map(v.asString -> v.asNumber, v.asNumber.toString -> v.asNumber)).toMap
}
