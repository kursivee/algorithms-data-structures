package adventofcode.y2020

import adventofcode.util.FileUtil

class Day6 {
    fun solve(list: List<String>): Int {
        var total = 0
        val set = mutableSetOf<Char>()
        list.forEach { s ->
            if(s.isNotEmpty()) {
                s.forEach { c ->
                    set.add(c)
                }
            } else {
                total += set.size
                set.clear()
            }
        }
        return total
    }

    fun solve2(list: List<String>): Int {
        var total = 0
        var people = 0
        val map = mutableMapOf<Char, Int>()
        list.forEach { s ->
            if(s.isNotEmpty()) {
                s.forEach { c ->
                    map[c] = map.getOrDefault(c, 0) + 1
                }
                people++
            } else {
                map.values.forEach { v ->
                    if(v == people) total += 1
                }
                people = 0
                map.clear()
            }
        }
        return total
    }
}

fun main() {
    val list = FileUtil.read("day6.txt").split("\n")
    println(Day6().solve(list))
    println(Day6().solve2(list))
}