package leetcode.easy.peakmountainindex_852

// https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/
class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var ans = -1
        for(i in 1 until arr.size - 1) {
            if(arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) return i
        }
        return ans
    }
}

fun main() {
    Solution().peakIndexInMountainArray(intArrayOf(0, 2, 1, 0)).also {
        println(it)
    }
}