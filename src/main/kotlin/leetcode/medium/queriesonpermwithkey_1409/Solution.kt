package leetcode.medium.queriesonpermwithkey_1409

class Solution {
    fun processQueries(queries: IntArray, m: Int): IntArray {
        val arr = IntArray(m)
        for(i in 0 until m) {
            arr[i] = i+1
        }
        val ans = IntArray(queries.size)

        for(i in queries.indices) {
            val target = queries[i]
            val targetIndex = arr.indexOf(target)
            ans[i] = targetIndex
            arr.add(targetIndex, target)
        }
        return ans
    }

    fun IntArray.add(endIndex: Int, item: Int) {
        for(i in endIndex downTo 1) {
            this[i] = this[i-1]
        }
        this[0] = item
    }
}

fun main() {
    Solution().processQueries(intArrayOf(3,1,2), 5).also {
        println(it.joinToString(", "))
    }
}