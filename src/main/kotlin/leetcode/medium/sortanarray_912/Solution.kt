package leetcode.medium.sortanarray_912

class Solution {
    fun sortArray(nums: IntArray): IntArray {
        if(nums.size <= 1) return nums
        val mid = (nums.size / 2)
        val left = nums.copyOfRange(0, mid)
        val right = nums.copyOfRange(mid, nums.size)
        return sort(sortArray(left), sortArray(right))
    }

    fun sort(left: IntArray, right: IntArray): IntArray {
        var indexLeft = 0
        var indexRight = 0
        var ansIndex = 0
        val ans = IntArray(left.size + right.size)

        while(indexLeft < left.size && indexRight < right.size) {
            if(left[indexLeft] <= right[indexRight]) {
                ans[ansIndex++] = left[indexLeft++]
            } else {
                ans[ansIndex++] = right[indexRight++]
            }
        }

        while(indexLeft < left.size) {
            ans[ansIndex++] = left[indexLeft++]
        }
        while(indexRight < right.size) {
            ans[ansIndex++] = right[indexRight++]
        }
        return ans
    }
}

fun main() {
    Solution().sortArray(intArrayOf(5,2,3,1))
        .also {
            println(it.joinToString(", "))
        }
}
