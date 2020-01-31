package leetcode.easy.decompress_1313

// https://leetcode.com/problems/decompress-run-length-encoded-list/submissions/
class Solution {
    fun decompressRLElist(nums: IntArray = intArrayOf(1,2,3,4)): IntArray {
        var sum = 0
        for(i in 0..nums.size - 2 step 2) {
            sum += nums[i]
        }
        var arr = IntArray(sum)
        var arrI = 0
        for(i in 0..nums.size - 2 step 2) {
            repeat(nums[i]) {
                arr[arrI++] = nums[i+1]
            }
        }
        return arr
    }
}

fun main() {
    Solution().decompressRLElist().joinToString(", ").also { println(it) }
}