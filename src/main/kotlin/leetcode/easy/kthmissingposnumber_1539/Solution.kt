package leetcode.easy.kthmissingposnumber_1539

class Solution {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var count = 0
        var curr = 1
        for(i in 1 .. Int.MAX_VALUE) {
            if(!arr.contains(i)) {
                count++
                if(count == k) return i
            }
        }
        return -1
    }
}