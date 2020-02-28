package leetcode.easy.intersectiontwoarray_349

// https://leetcode.com/problems/intersection-of-two-arrays/
class Solution {
    fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {
        val small: IntArray
        val big: IntArray
        if(nums1.size > nums2.size) {
            big = nums1
            small = nums2
        } else {
            big = nums2
            small = nums1
        }
        return small.toSet().filter {
            big.contains(it)
        }.toIntArray()
    }

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val small: IntArray
        val big: IntArray
        if(nums1.size > nums2.size) {
            big = nums1
            small = nums2
        } else {
            big = nums2
            small = nums1
        }
        big.sort()
        return small.toSet().filter {
            big.binSearch(it)
        }.toIntArray()

    }

    private fun IntArray.binSearch(target: Int): Boolean {
        var l = 0
        var r = size - 1
        while(l <= r) {
            val i = (l+r)/2
            val n = get(i)
            when {
                n == target -> return true
                n > target -> r = i - 1
                n < target -> l = i + 1
            }
        }
        return false
    }
}

fun main() {
    Solution().intersection(
        intArrayOf(1,2,2,1),
        intArrayOf(2,2)
    ).also {
        println(it.joinToString(", "))
    }

    Solution().intersection(
        intArrayOf(4,9,5),
        intArrayOf(9,4,9,8,4)
    ).also {
        println(it.joinToString(", "))
    }
}