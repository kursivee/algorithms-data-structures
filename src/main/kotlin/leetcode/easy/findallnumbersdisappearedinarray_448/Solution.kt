package leetcode.easy.findallnumbersdisappearedinarray_448

class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        for(i in nums.indices) {
            val index = Math.abs(nums[i]) - 1
            if(nums[index] > 0) {
                nums[index] *= -1
            }
        }
        val list = mutableListOf<Int>()
        for(i in nums.indices) {
            if(nums[i] > 0) list.add(i + 1)
        }
        return list
    }

    fun findDisappearedNumbersSlow(nums: IntArray): List<Int> {
        val arr = IntArray(nums.size + 1)
        for(n in nums) {
            arr[n] += 1
        }
        val list = mutableListOf<Int>()
        for(i in 1 until arr.size) {
            if(arr[i] == 0) list.add(i)
        }
        return list
    }
}