package org.tage.sample.robot
// time kotlin -cp build/libs/mic_importer-1.0-SNAPSHOT.jar org.tage.sample.robot.RobotPositionKt UDDLLRUUUDUURUDDUULLDRRRR


data class Pos(val x: Int, val y: Int)
sealed class Move(val m: Char, val position: Pos = Pos(0, 0)) {
    companion object {
        fun parse(m: Char, last: Move): Move = when (m) {
            'U' -> Up(last)
            'D' -> Down(last)
            'L' -> Left(last)
            'R' -> Right(last)
            else -> Unknown(m, last)
        }
    }
}

class Up(last: Move) : Move('U', last.position.copy(y = last.position.y + 1))
class Down(last: Move) : Move('D', last.position.copy(y = last.position.y - 1))
class Left(last: Move) : Move('L', last.position.copy(x = last.position.x - 1))
class Right(last: Move) : Move('R', last.position.copy(x = last.position.x + 1))
class Unknown(mm: Char, last: Move) : Move(mm, last.position) {
    init {
        println("unknown move '$m'")
    }
}

object Start : Move('_')

fun finalPosition(move: String): Pos =
    IntRange(0, move.length - 1)
        .fold(Start as Move) { last, idx -> Move.parse(move[idx], last) }
        .position

class RobotPosition {
    companion object {
        @JvmStatic fun javaFinalPosition(move: String): Pos = finalPosition(move)
        @JvmStatic fun main(args: Array<String>) {
            args.map { moves -> finalPosition(moves) }.forEach { println(it) }
        }
    }
}
