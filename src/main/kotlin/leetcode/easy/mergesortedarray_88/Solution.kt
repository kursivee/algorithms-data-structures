package leetcode.easy.mergesortedarray_88

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if(n == 0) return
        var l = 0
        var r = 0
        var offset = 0
        while(l < m + n && r < n) {
            if(l >= m + offset) {
                nums1[l] = nums2[r++]
            } else if(nums1[l] > nums2[r]) {
                nums1.shiftRight(l)
                nums1[l] = nums2[r++]
                offset++
            }
            l++
        }
    }

    private fun IntArray.shiftRight(start: Int) {
        for(i in size - 1 downTo start + 1) {
            this[i] = this[i - 1]
        }
    }
}