package leetcode.medium.findsmallestcommoneleinrows_1198

class Solution {
    fun smallestCommonElement(mat: Array<IntArray>): Int {
        val map = mutableMapOf<Int, Int>()
        for(i in mat.indices) {
            for(j in mat[0].indices) {
                val count = map.getOrDefault(mat[i][j], 0)
                map[mat[i][j]] = count + 1
            }
        }
        var min = Int.MAX_VALUE
        map.entries.forEach { entry ->
            if(entry.value == mat.size) {
                min = Math.min(entry.key, min)
            }
        }
        return if(min == Int.MAX_VALUE) -1 else min
    }

    fun smallestCommonElementBinSearch(mat: Array<IntArray>): Int {
        for(i in mat[0].indices) {
            val target = mat[0][i]
            var bool = true
            for(j in 1 until mat.size) {
                if(!mat[j].search(target)) {
                    bool = false
                    break
                }
            }
            if(bool) {
                return target
            }
        }
        return -1
    }

    private fun IntArray.search(target: Int): Boolean {
        var l = 0
        var r = size - 1
        while(l <= r) {
            val midpoint = l + (r - l) / 2
            val n = this[midpoint]
            if(n == target) return true
            if(n > target) {
                r = midpoint - 1
            } else {
                l = midpoint + 1
            }
        }

        return false
    }
}