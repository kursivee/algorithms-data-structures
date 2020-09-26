package leetcode.medium.dotproductoftwosparsevectors_1570

class SparseVector(val nums: IntArray) {
    // Return the dotProduct of two sparse vectors
    fun dotProduct(vec: SparseVector): Int {
        var product = 0
        for(i in nums.indices) {
            product += nums[i] * vec.nums[i]
        }
        return product
    }
}

/**
 * Your SparseVector object will be instantiated and called as such:
 * var v1 = SparseVector(nums1)
 * var v2 = SparseVector(nums2)
 * val ans = v1.dotProduct(v2)
 */