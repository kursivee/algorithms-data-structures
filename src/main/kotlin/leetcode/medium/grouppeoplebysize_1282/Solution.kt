package leetcode.medium.grouppeoplebysize_1282

class Solution {
    val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        groupSizes.forEachIndexed { index, size ->
            addToMap(index, size)
        }
        val group: MutableList<List<Int>> = mutableListOf()
        map.forEach { entry ->
            group.addAll(entry.value.chunked(entry.key))
        }
        return group
    }

    private fun addToMap(index: Int, size: Int) {
        val list = map.getOrPut(size, { mutableListOf() })
        list.add(index)
    }
}

fun main() {
    Solution().also { solution ->
        solution.groupThePeople(intArrayOf(2,1,3,3,3,2)).also {
            println(it.joinToString(", "))
        }
    }
}
