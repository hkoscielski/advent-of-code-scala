package aoc.aoc2021.day2

abstract class Command
case class Down(value: Int) extends Command
case class Forward(value: Int) extends Command
case class Up(value: Int) extends Command

case object CommandFactory {

  def createCommand(command: String, value: Int): Command = command match {
    case "down" => Down(value)
    case "forward" => Forward(value)
    case "up" => Up(value)
    case _ => throw new IllegalArgumentException(s"Unsupported command: $command")
  }
}