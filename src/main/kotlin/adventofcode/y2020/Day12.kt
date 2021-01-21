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
                        when((abs(deg) % 360) / 90) {
                            1 -> y += n
                            2 -> x += n
                            3 -> y -= n
                            0 -> x -= n
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
        }
        return abs(x) + abs(y)
    }

    data class DataPoint(
        val x: Int,
        val y: Int
    )

    fun DataPoint.add(x: Int, y: Int): DataPoint {
        return DataPoint(this.x + x, this.y + y)
    }

    fun solve2(list: List<String>): Int {
        var ship = DataPoint(0, 0)
        var waypoint = DataPoint(10, 1)
        list.forEach { s ->
            val command = s[0]
            val n = s.substring(1 until s.length).toInt()
            when(command) {
                'N' -> waypoint = DataPoint(waypoint.x, waypoint.y + n)
                'E' -> waypoint = DataPoint(waypoint.x + n, waypoint.y)
                'S' -> waypoint = DataPoint(waypoint.x, waypoint.y - n)
                'W' -> waypoint = DataPoint(waypoint.x - n, waypoint.y)
                'R' -> {
                    when((n % 360) / 90) {
                        1 -> {
                            waypoint = DataPoint(waypoint.y, waypoint.x * -1)
                        }
                        2 -> {
                            waypoint = DataPoint(waypoint.x * -1, waypoint.y * -1)
                        }
                        3 -> {
                            waypoint = DataPoint(waypoint.y * -1, waypoint.x)
                        }
                    }
                }
                'L' -> {
                    when((n % 360) / 90) {
                        3 -> {
                            waypoint = DataPoint(waypoint.y, waypoint.x * -1)
                        }
                        2 -> {
                            waypoint = DataPoint(waypoint.x * -1, waypoint.y * -1)
                        }
                        1 -> {
                            waypoint = DataPoint(waypoint.y * -1, waypoint.x)
                        }
                    }
                }
                'F' -> {
                    ship = ship.add(waypoint.x * n, waypoint.y * n)
                }
            }
        }
        return abs(ship.x) + abs(ship.y)
    }
}

fun main() {
    val list = FileUtil.read("day12a.txt").split("\n")
    val solve = Day12()
    println(solve.solve(list))
    println(solve.solve2(list))
}