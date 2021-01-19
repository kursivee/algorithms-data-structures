package adventofcode.y2020

import adventofcode.util.FileUtil

class Day10 {
    fun solve(list: List<Int>): Int {
        val sorted = list.sorted()
        var one = 0
        var three = 1
        if(sorted[0] == 1) one++
        else if(sorted[0] == 3) three++
        for(i in 1 until sorted.size) {
            val diff = sorted[i] - sorted[i - 1]
            if(diff == 1) one++
            else if(diff == 3) three++
        }
        return one * three
    }

    fun solve2(list: List<Int>): Long {
        val sorted = list.sorted()
        var count = 0L
        repeat(3) {
            count += traverse(sorted, it, 0)
        }
        return count
    }

    private val cache = mutableMapOf<Int, Long>()
    private fun traverse(list: List<Int>, index: Int, prev: Int): Long {
        val curr = list[index]
        if(curr - prev > 3) return 0
        if(index == list.size - 1) {
            return 1
        }
        if(cache.containsKey(index)) {
            return cache[index]!!
        }
        var count = 0L
        for(i in index + 1 until list.size) {
            count += traverse(list, i, curr)
        }
        cache[index] = count
        return count
    }
}

fun main() {
    val list = FileUtil.read("day10.txt").split("\n").map {
        it.toInt()
    }
    val day10 = Day10()
    println(day10.solve(list))
    println(day10.solve2(list))

}