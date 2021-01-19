package adventofcode.y2020

import adventofcode.util.FileUtil

class Day9 {
    fun solve(list: List<Long>): Long {
        var l = 0
        var r = 24
        while(r < list.size - 1) {
            val curr = list[r + 1]
            var bool = false
            val sublist = list.subList(l, r + 1)
            for(i in l .. r) {
                if(sublist.contains(curr - list[i])) {
                    bool = true
                    break
                }
            }
            if(!bool) return curr
            l++
            r++
        }
        return -1
    }

    fun solve2(list: List<Long>, target: Long): Long {
        for(i in 0 until list.size - 1) {
            var sum = list[i]
            for(j in i + 1 until list.size) {
                sum += list[j]
                if(sum == target) {
                    val subList = list.subList(i, j + 1)
                    return subList.max()!! + subList.min()!!
                }
                if(sum > target) break
            }
        }
        return -1L
    }

    fun solve3(list: List<Long>, target: Long): Long {
        var l = 0
        var r = 1
        var sum = list[l]
        while(r < list.size) {
            if(sum == target) {
                val subList = list.subList(l, r + 1)
                return subList.max()!! + subList.min()!!
            }
            if(sum < target) {
                sum += list[r++]
            }
            if(sum > target) {
                sum -= list[l++]
            }
        }
        return -1L
    }
}

fun main() {
    val list = FileUtil.read("day9.txt").split("\n").map { it.toLong() }
    val day1Ans = Day9().solve(list)
    println(day1Ans)
    println(Day9().solve3(list, day1Ans))
}