package leetcode.medium.combinationsumiii_216
class Solution {
    private val list = mutableListOf<List<Int>>()

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        for(i in 1 .. 9) {
            traverse(i, k, n, listOf())
        }
        return list
    }

    private fun traverse(i: Int, k: Int, n: Int, prev: List<Int>) {
        if(i == 10 || prev.size == k) return
        val next = prev.toMutableList()
        next.add(i)
        if(next.size == k) {
            if(next.sum() == n) {
                if(!list.contains(next))
                    list.add(next)
            }
            return
        }
        for(j in i + 1 .. 9) {
            traverse(j, k, n, next)
        }
    }
}