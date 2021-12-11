package aoc.aoc2021.day2

class EnhancedSubmarine(override val position: EnhancedPosition = new EnhancedPosition) extends Submarine(position) {

  override def executeCommand(command: Command): EnhancedSubmarine = command match {
    case Down(value) => new EnhancedSubmarine(new EnhancedPosition(position.depth, position.horizontal, position.aim + value))
    case Forward(value) => new EnhancedSubmarine(new EnhancedPosition(position.depth + position.aim * value, position.horizontal + value, position.aim))
    case Up(value) => new EnhancedSubmarine(new EnhancedPosition(position.depth, position.horizontal, position.aim - value))
    case c => throw new IllegalArgumentException(s"Unsupported command: $c")
  }
}
