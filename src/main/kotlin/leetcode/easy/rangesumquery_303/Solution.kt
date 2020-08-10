package leetcode.easy.rangesumquery_303

class NumArray(nums: IntArray) {
    /*
    Tag: Prefix Sum
    Intuition:
    Initialize a prefix sum array
    sum of range is
    the sum of the j index - the sum of the i index - 1
    */
    private val prefixSum = IntArray(nums.size)

    init {
        for(i in nums.indices) {
            val step = if(i == 0) 0 else prefixSum[i - 1]
            prefixSum[i] = nums[i] + step
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        val sum = if(i - 1 < 0) 0 else prefixSum[i - 1]
        return prefixSum[j] - sum
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */