package leetcode.easy.findcommonchars_1002

// https://leetcode.com/problems/find-common-characters/submissions/
class Solution {
    private var initSize = 0

    fun commonChars(A: Array<String>): List<String> {
        initSize = A.size - 1
        val charMap = mutableMapOf<Char, MutableList<Int>>()
        val list = mutableListOf<String>()
        A.forEachIndexed { i, s ->
            s.forEach { c ->
                charMap.add(c, i)
            }
        }
        charMap.forEach { entry ->
            val count = entry.value.min()
            repeat(count) {
                list.add(entry.key.toString())
            }
        }

        return list
    }

    private fun MutableMap<Char, MutableList<Int>>.add(c: Char, index: Int) {
        this[c]?.let {
            it[index] = (it[index] + 1)
        } ?: run {
            val list = MutableList(initSize) { 0 }
            list.add(index, 1)
            put(c, list)
        }
    }

    private fun List<Int>.min(): Int {
        var min = Int.MAX_VALUE
        forEach {
            if(it < min) min = it
        }
        return min
    }
}

fun main() {
    Solution().commonChars(arrayOf(
        "bella","label","roller"
    )).also { println(it) }

    Solution().commonChars(arrayOf(
        "cool","lock","cook"
    )).also { println(it) }

    Solution().commonChars(arrayOf(
        "aaa", "bbb"
    )).also { println(it) }
}