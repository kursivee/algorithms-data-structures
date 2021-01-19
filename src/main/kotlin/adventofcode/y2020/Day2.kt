package adventofcode.y2020

import adventofcode.util.FileUtil

data class Item(
    val range: List<Int>,
    val c: Char,
    val password: String
) {
    fun isValid(): Boolean {
        var count = 0
        password.forEach { char ->
            if(c == char) count++
        }
        return count >= range[0] && count <= range[1]
    }

    fun isInPosition(): Boolean {
        return (password[range[0] - 1] == c) xor (password[range[1] - 1] == c)
    }
}

fun main() {
    val list = FileUtil.read("day2.txt").split("\n").map {  s ->
        val items = s.split(" ")
        val ranges = items[0].split("-")
        Item(
            listOf(ranges[0].trim().toInt(), ranges[1].trim().toInt()),
            items[1][0],
            items[2].trim()
        )
    }
    println(list)
    var count = 0
    list.forEach {  item ->
        if(item.isValid()) count++
    }
    println(count)

    count = 0
    list.forEach {  item ->
        if(item.isInPosition()) count++
    }
    println(count)
}