package leetcode.easy.minvaluestepbystepsum_1413

class Solution {
    /*
    -3,2,-3,4,2
    prefix

    -3
    -3, -1
    -3, -1, -4
    -3, -1, -4, 0
    -3, -1, -4, 0, 2

    Intuition: Prefix sum
    calculate the prefix sum of the array
    the min value in the prefix sum will indicate start value
    if min value >= 0 then answer is 1 (must be min POSTIIVE int)
    else return the (min value * -1) + 1 (must +1 since sum must never be less than 1)
    */
    fun minStartValue(nums: IntArray): Int {
        val prefix = IntArray(nums.size)
        prefix[0] = nums[0]
        for(i in 1 until nums.size) {
            prefix[i] = prefix[i - 1] + nums[i]
        }
        val min = prefix.min()!!
        if(min >= 0) return 1
        return (min * -1) + 1
    }
}