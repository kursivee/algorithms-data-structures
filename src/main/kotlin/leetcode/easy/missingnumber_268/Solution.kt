package leetcode.easy.missingnumber_268

class Solution {
    fun missingNumber(nums: IntArray): Int {
        val arr = IntArray(nums.size + 1)
        nums.forEach { i ->
            arr[i] = -1
        }
        for(i in arr.indices) {
            if(arr[i] == 0) return i
        }
        return -1
    }
}