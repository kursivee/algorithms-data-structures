package leetcode.hard.findminrotatedarrayII_154

class Solution {
    fun findMin(nums: IntArray): Int {
        if(nums.size == 1) return nums[0]
        var l = 0
        var r = nums.size - 1
        while(l < r) {
            val mid = (l + r) / 2
            val x = nums[mid]
            if(x == nums[l] && x == nums[r]) {
                if(isMoveLeft(nums, l, r, nums[r], mid)) {
                    l = mid + 1
                } else {
                    r = mid
                }
            } else if(x > nums[r]) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        nums.forEachIndexed { index, i ->  }
        return nums[l]
    }

    fun isMoveLeft(nums: IntArray, l: Int, r: Int, target: Int, mid: Int): Boolean {
        var lCount = 0
        var rCount = 0
        var lIndex = l
        var rIndex = r
        while((lIndex < mid && nums[lIndex] == target) || (rIndex > mid && nums[rIndex] == target)) {
            if(nums[lIndex++] == target) lCount++
            if(nums[rIndex--] == target) rCount++
        }
        return lCount >= rCount
    }
}

fun main() {
    Solution().findMin(intArrayOf(1,1,3,1)).also {
        println(it)
    }
}