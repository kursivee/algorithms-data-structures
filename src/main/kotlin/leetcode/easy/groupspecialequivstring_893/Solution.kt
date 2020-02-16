package leetcode.easy.groupspecialequivstring_893

// https://leetcode.com/problems/groups-of-special-equivalent-strings/
class Solution {
    fun numSpecialEquivGroups(A: Array<String>): Int {
        return A.toSetWithCount().size
    }

    private fun Array<String>.toSetWithCount(): Set<String> {
        val map = mutableMapOf<String, Int>()
        forEach {
            val s = it.subsetSort()
            map[s] = (map[s] ?: 0) + 1
        }
        return map.keys
    }

    private fun String.subsetSort(): String {
        var sEven = ""
        var sOdd = ""
        forEachIndexed { index, c ->
            if(index % 2 == 0) {
                sEven += c
            } else {
                sOdd += c
            }
        }
        sEven = sEven.toCharArray().also { it.sort() }.joinToString("")
        sOdd = sOdd.toCharArray().also { it.sort() }.joinToString("")
        return "$sEven$sOdd"
    }
}

fun main() {
    Solution().numSpecialEquivGroups(arrayOf(
        "abcd","cdab","cbad","xyzz","zzxy","zzyx"
    )).also {
        println(it == 3)
    }

    Solution().numSpecialEquivGroups(arrayOf(
        "abc","acb","bac","bca","cab","cba"
    )).also {
        println(it == 3)
    }

    Solution().numSpecialEquivGroups(arrayOf(
        "ababaa","aaabaa"
    )).also {
        println(it == 2)
    }
}