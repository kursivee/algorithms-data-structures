package adventofcode.y2020

import java.io.File
import java.io.FileNotFoundException

fun main() {
    val list = resourceFileText("day1.txt").split("\n").map {
        it.toInt()
    }.toMutableList()
    println(solve(list, 2020, listOf(), 2)) // Solve for part 1
    println(solve(list, 2020, listOf(), 3)) // Solve for part 2
}

fun solve(list: List<Int>, target: Int, ansList: List<Int>, maxLimit: Int): Int {
    val sum = ansList.sum()
    if(ansList.size > maxLimit || sum > target) return -1
    if(sum == target && ansList.size == maxLimit) {
        return ansList.reduce { acc, i ->
            acc * i
        }
    }
    for((index, n) in list.withIndex()) {
        val newFullList = list.toMutableList()
        newFullList.removeAt(index)
        val newAnsList = ansList.toMutableList()
        newAnsList.add(n)
        val ans = solve(newFullList, target, newAnsList, maxLimit)
        if(ans != -1) return ans
    }
    return -1
}

fun resourceFileText(path: String, trim: Boolean = true): String {
    val resource = Int::class.java.getResource(path)
    if (resource == null) throw FileNotFoundException("could not load '$path'")
    val file = File(resource.toURI())
    return file.readText()
}