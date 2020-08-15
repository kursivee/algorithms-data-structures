package leetcode.easy.maketwoarraysequalbyreversingsubarrays_1460

class Solution {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val ans = IntArray(1001)
        if(target.size != arr.size) return false
        for(i in target.indices) {
            ans[target[i]] += 1
            ans[arr[i]] += 1
        }
        ans.forEach { i ->
            if(i % 2 == 1) return false
        }
        return true
    }
}