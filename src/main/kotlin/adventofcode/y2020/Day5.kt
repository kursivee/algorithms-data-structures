package adventofcode.y2020

import adventofcode.util.FileUtil

class Day5 {
    fun solve(list: List<String>): Int {
        return list.toIds().max() ?: -1
    }

    fun solve2(list: List<String>): Int {
        val sortedList = list.toIds().sorted()
        for(i in 1 until sortedList.size) {
            if(sortedList[i] - sortedList[i - 1] == 2) {
                return sortedList[i] - 1
            }
        }
        return -1
    }

    private fun String.parse(start: Int, end: Int): Int {
        var l = start
        var r = end
        for(c in this) {
            when(c) {
                'F', 'L' -> {
                    r = (l + r) / 2
                }
                else -> {
                    l = (l + r + 1) / 2
                }
            }
        }
        return l
    }

    private fun List<String>.toIds(): List<Int> {
        return map {  s ->
            val row = s.substring(0, 7).parse(0, 127)
            val col = s.substring(7).parse(0, 7)
            row * 8 + col
        }
    }
}

fun main() {
    val list = FileUtil.read("day5.txt").split("\n")
    println(Day5().solve(list))
    println(Day5().solve2(list))
}