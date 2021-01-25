package leetcode.easy.removeelement_27

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var count = 0
        var i = 0
        while(i < nums.size) {
            if(nums[i] == `val`) {
                nums.left(i)
                count++
            } else i++
            if(i == nums.size - count) break
        }
        return nums.size - count
    }

    private fun IntArray.left(start: Int) {
        for(i in start + 1 until size) {
            this[i - 1] = this[i]
        }
    }

    fun removeElement2(nums: IntArray, `val`: Int): Int {
        var i = 0
        var j = nums.size
        while(i < j) {
            if(nums[i] == `val`) {
                nums[i] = nums[--j]
            } else i++
        }
        return j
    }
}