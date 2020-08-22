package leetcode.medium.minnumoffuncallstargetarray_1558

class Solution {
    fun minOperations(nums: IntArray): Int {
        var count = 0
        while(nums.sum() != 0) {
            count += nums.toEven()
            count++
            nums.div2()
        }
        return if(count - 1 < 0) 0 else count - 1
    }

    private fun IntArray.div2() {
        for(i in this.indices) {
            this[i] /= 2
        }
    }

    private fun IntArray.toEven(): Int {
        var count = 0
        for(i in this.indices) {
            if(this[i] % 2 == 1) {
                count++
                this[i] -= 1
            }
        }
        return count
    }
}