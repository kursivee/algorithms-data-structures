package leetcode.medium.numberswithsameconsecdiff_967

class Solution {
    private val ans = mutableListOf<Int>()
    fun numsSameConsecDiff(N: Int, K: Int): IntArray {
        for(i in 0..9) {
            if(N > 1 && i == 0) continue
            dfs(i, N, K, listOf())
        }
        return ans.toIntArray()
    }

    private fun dfs(n: Int, length: Int, k: Int, digits: List<Int>) {
        val list = digits.toMutableList()
        if(digits.isEmpty()) {
            list.add(n)
        } else {
            var diff = Math.abs(digits[digits.size - 1] - n)
            if(diff != k) return
            list.add(n)
        }
        if(list.size == length) {
            ans.add(list.joinToString("").toInt())
            return
        }
        for(i in 0 .. 9) {
            dfs(i, length, k, list)
        }
    }
}