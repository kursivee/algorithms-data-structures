package leetcode.easy.nexgreaterelem_496

// https://leetcode.com/problems/next-greater-element-i/
class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val arr = IntArray(nums1.size)
        nums1.forEachIndexed { index, int ->
            var i = 0
            var track = false
            var x = -1
            while(i < nums2.size) {
                if(track) {
                    if(nums2[i] > int) {
                        x = nums2[i]
                        break
                    }
                }
                if(nums2[i] == int) {
                    track = true
                }
                i++
            }
            arr[index] = x
        }
        return arr
    }
}

fun main() {
    Solution().nextGreaterElement(intArrayOf(
        4,1,2
    ), intArrayOf(
        1,3,4,2
    )).also { println(it.joinToString(", ")) }

    Solution().nextGreaterElement(intArrayOf(
        2,4
    ), intArrayOf(
        1,2,3,4
    )).also { println(it.joinToString(", ")) }
}