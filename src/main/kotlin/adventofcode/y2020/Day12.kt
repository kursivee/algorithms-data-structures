package adventofcode.y2020

import adventofcode.util.FileUtil
import kotlin.math.abs

class Day12 {
    fun solve(list: List<String>): Int {
        var x = 0
        var y = 0
        var deg = 90
        list.forEach { s ->
            val dir = s[0]
            val n = s.substring(1 until s.length).toInt()
            when(dir) {
                'N' -> { y += n}
                'W' -> { x -= n}
                'E' -> { x += n}
                'S' -> { y -= n}
                'F' -> {
                    if(deg >= 0) {
                        when((deg % 360) / 90) {
                            0 -> y += n
                            1 -> x += n
                            2 -> y -= n
                            3 -> x -= n
                        }
                    } else {
                        when((abs(deg + 360) % 360) / 90) {
                            0 -> y += n
                            1 -> x += n
                            2 -> y -= n
                            3 -> x -= n
                        }
                    }
                }
                'L' -> {
                    deg -= n
                }
                'R' -> {
                    deg += n
                }
            }
            println("$x $y")
        }
        return abs(x) + abs(y)
    }
}

fun main() {
    val list = FileUtil.read("day12a.txt").split("\n")
    val solve = Day12()
    println(solve.solve(list))
}