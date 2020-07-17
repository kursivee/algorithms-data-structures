package leetcode.medium.grouppeoplebysize_1282

class Solution {
    val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val grouped = groupSizes.withIndex().groupBy({ it.value }, { it.index })
        return grouped.map { entry ->
            entry.value.chunked(entry.key).flatten()
        }
    }
}

fun main() {
    Solution().also { solution ->
        solution.groupThePeople(intArrayOf(2,1,3,3,3,2)).also {
            println(it.joinToString(", "))
        }
    }
}
