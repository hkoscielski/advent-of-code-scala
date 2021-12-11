package aoc.aoc2021.day2

import scala.annotation.tailrec

class Submarine(val position: Position = new Position) {

  final def multipliedCoordinates: Int = position.depth * position.horizontal

  final def executeCommands(commands: List[Command]): Submarine = {
    @tailrec
    def executeCommands(commands: List[Command], submarine: Submarine): Submarine = {
      commands match {
        case Nil => submarine
        case head :: tail => executeCommands(tail, submarine.executeCommand(head))
      }
    }

    executeCommands(commands, this)
  }

  protected def executeCommand(command: Command): Submarine = command match {
    case Down(value) => new Submarine(new Position(position.depth + value, position.horizontal))
    case Forward(value) => new Submarine(new Position(position.depth, position.horizontal + value))
    case Up(value) => new Submarine(new Position(position.depth - value, position.horizontal))
    case c => throw new IllegalArgumentException(s"Unsupported command: $c")
  }
}
