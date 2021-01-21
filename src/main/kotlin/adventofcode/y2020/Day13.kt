package adventofcode.y2020

import adventofcode.util.FileUtil

class Day13 {
    fun solve(start: Int, buses: List<Int>): Int {
        var id = buses[0]
        var min = Int.MAX_VALUE
        buses.forEach { bus ->
            if(bus % start == 0) return bus
            val diff = (bus * (start / bus + 1)) - start
            if(diff < min) {
                min = diff
                id = bus
            }
        }
        return id * min
    }

    private var max = 0
    private var maxOffset = 1L

    fun solve2(buses: Map<Int, Int>): Long {
        var timestamp = 0L
        val keys = buses.keys.toList()
        val values = buses.values.toList()
        while(true) {
            if(so(timestamp, keys, values)) {
                return timestamp
            }
            timestamp += maxOffset
        }
    }

    private fun so(start: Long, indexes: List<Int>, buses: List<Int>): Boolean {
        for(i in indexes.indices) {
            if((start + indexes[i]) % buses[i] != 0L) {
                return false
            } else {
                if(i > max) {
                    maxOffset *= buses[i]
                    max = i
                }
            }
        }
        return true
    }
}

fun main() {
    val list = FileUtil.read("day13.txt").split("\n")
    val start = list[0].toInt()
    val buses = list[1].split(",").filter { it != "x" }.map { it.toInt() }
    val solver = Day13()
    println(solver.solve(start, buses))
    val map = mutableMapOf<Int, Int>()
    list[1].split(",").forEachIndexed { index, s ->
        if(s != "x") {
            map[index] = s.toInt()
        }
    }
    println(solver.solve2(map))
}