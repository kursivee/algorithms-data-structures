package leetcode.medium.numbergoodsplitstring_1525

class Solution {

    val setLeft = mutableSetOf<Char>()
    val mapRight = mutableMapOf<Char, Int>()

    fun numSplits(s: String): Int {
        var count = 0
        s.forEach {
            val c = mapRight.getOrDefault(it, 0)
            mapRight[it] = c + 1
        }
        for(i in 1 until s.length) {
            val l = s.substring(0, i)
            mapRight[l.last()]?.let {
                mapRight[l[l.length - 1]] = it - 1
            }
            setLeft.add(l.last())
            if(setLeft.size == mapRight.nonZeroSize()) count ++
        }
        return count
    }

    fun Map<Char, Int>.nonZeroSize(): Int {
        var count = 0
        entries.forEach {
            if(it.value != 0) count++
        }
        return count
    }
}

fun main() {
    Solution().numSplits("aacaba").also {
        println(it)
    }
}