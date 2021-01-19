package adventofcode.y2020

import adventofcode.util.FileUtil

fun main() {
    val list = FileUtil.read("day3.txt").split("\n")
    val ans1 = list.day3(1)
    val ans2 = list.day3(3)
    val ans3 = list.day3(5)
    val ans4 = list.day3(7)
    val ans5 = list.day3(1, 2)
    println(ans2)
    println(ans1 * ans2 * ans3 * ans4 * ans5)
}

fun List<String>.day3(right: Int, down: Int = 1): Long {
    var count = 0
    var j = 0
    for(i in indices step down) {
        if(this[i][j % this[0].length] == '#') count++
        j += right
    }
    return count.toLong()
}