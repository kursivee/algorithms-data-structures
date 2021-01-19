package adventofcode.y2020

import adventofcode.util.FileUtil

class Day11 {
    fun solve(arr: Array<CharArray>): Int {
        arr.adjCount(0, 0)
        while(true) {
            val change = mutableMapOf<Pair<Int, Int>, Char>()
            for(i in arr.indices) {
                for(j in arr[0].indices) {
                    if(arr[i][j] == '.') continue
                    val counts = arr.adjCount(i, j)
                    if(arr[i][j] == 'L' && counts.second == 0) {
                        change[i to j] = '#'
                    }
                    if(arr[i][j] == '#' && counts.second >= 4) {
                        change[i to j] = 'L'
                    }
                }
            }
            if(change.isEmpty()) {
                return arr.occupiedCount()
            }
            change.forEach { entry ->
                arr[entry.key.first][entry.key.second] = entry.value
            }
        }
    }

    fun solve2(arr: Array<CharArray>): Int {
        while(true) {
            val change = mutableMapOf<Pair<Int, Int>, Char>()
            for(i in arr.indices) {
                for(j in arr[0].indices) {
                    if(arr[i][j] == '.') continue
                    if(i == 0 && j == 2) {
                        println()
                    }
                    val counts = arr.adjCount2(i, j)

                    if(arr[i][j] == 'L' && counts == 0) {
                        change[i to j] = '#'
                    }
                    if(arr[i][j] == '#' && counts >= 5) {
                        change[i to j] = 'L'
                    }
                }
            }
            if(change.isEmpty()) {
                return arr.occupiedCount()
            }
            change.forEach { entry ->
                arr[entry.key.first][entry.key.second] = entry.value
            }
            arr.forEach {
                println(it.joinToString(""))
            }
            println()
        }
    }

    private fun Array<CharArray>.occupiedCount(): Int {
        var count = 0
        for(i in indices) {
            for(j in this[0].indices) {
                if(this[i][j] == '#') count++
            }
        }
        return count
    }

    fun Array<CharArray>.adjCount(i: Int, j: Int): Pair<Int, Int> {
        var empty = 0
        var occupied = 0
        if(i > 0) {
            if(this[i - 1][j] ==  'L') empty++
            if(this[i - 1][j] ==  '#') occupied++
        }
        if(i > 0 && j > 0) {
            if(this[i - 1][j - 1] ==  'L') empty++
            if(this[i - 1][j - 1] ==  '#') occupied++
        }
        if(j > 0) {
            if(this[i][j - 1] ==  'L') empty++
            if(this[i][j - 1] ==  '#') occupied++
        }
        if(i < size - 1 && j > 0) {
            if(this[i + 1][j - 1] ==  'L') empty++
            if(this[i + 1][j - 1] ==  '#') occupied++
        }
        if(i < size - 1) {
            if(this[i + 1][j] ==  'L') empty++
            if(this[i + 1][j] ==  '#') occupied++
        }
        if(i < size - 1 && j < this[0].size - 1) {
            if(this[i + 1][j + 1] ==  'L') empty++
            if(this[i + 1][j + 1] ==  '#') occupied++
        }
        if(j < this[0].size - 1) {
            if(this[i][j + 1] ==  'L') empty++
            if(this[i][j + 1] ==  '#') occupied++
        }
        if(i > 0 && j < this[0].size - 1) {
            if(this[i - 1][j + 1] ==  'L') empty++
            if(this[i - 1][j + 1] ==  '#') occupied++
        }
        return empty to occupied
    }

    private fun Array<CharArray>.adjCount2(i: Int, j: Int): Int {
        var occupied = 0
        var x = 1
        while(i - x >= 0) {
            if(this[i - x][j] == 'L') break
            if(this[i - x][j] == '#') {
                occupied++
                break
            }
            x++
        }
        x = 1
        while(i - x >= 0 && j - x >= 0) {
            if(this[i - x][j - x] ==  'L') break
            if(this[i - x][j - x] ==  '#') {
                occupied++
                break
            }
            x++
        }
        x = 1
        while(j - x >= 0) {
            if(this[i][j - x] ==  'L') break
            if(this[i][j - x] ==  '#') {
                occupied++
                break
            }
            x++
        }
        x = 1
        while(i + x <= size - 1 && j - x >= 0) {
            if(this[i + x][j - x] ==  'L') break
            if(this[i + x][j - x] ==  '#') {
                occupied++
                break
            }
            x++
        }
        x = 1
        while(i + x <= size - 1) {
            if(this[i + x][j] ==  'L') break
            if(this[i + x][j] ==  '#') {
                occupied++
                break
            }
            x++
        }
        x = 1
        while(i + x <= size - 1 && j + x <= this[0].size - 1) {
            if(this[i + x][j + x] ==  'L') break
            if(this[i + x][j + x] ==  '#') {
                occupied++
                break
            }
            x++
        }
        x = 1
        while(j + x <= this[0].size - 1) {
            if(this[i][j + x] ==  'L') break
            if(this[i][j + x] ==  '#') {
                occupied++
                break
            }
            x++
        }
        x = 1
        while(i - x >= 0 && j + x <= this[0].size - 1) {
            if(this[i - x][j + x] ==  'L') break
            if(this[i - x][j + x] ==  '#') {
                occupied++
                break
            }
            x++
        }
        if(j == 2 && i == 0) println(occupied)
        return occupied
    }
}

fun main() {
    val arr = FileUtil.read("day11.txt").split("\n").map {
        it.toCharArray()
    }.toTypedArray()
    val solve = Day11()
//    println(solve.solve(arr))
    println(solve.solve2(arr))
}