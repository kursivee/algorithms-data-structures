package leetcode.easy.singlenumber_136

// https://leetcode.com/problems/single-number/
class Solution {


    fun singleNumber(nums: IntArray): Int {
        nums.sort()
        var count = 0
        var target = nums[0]
        nums.forEach {
            if(target == it) count++
            else {
                if(count % 2 != 0) return target
                target = it
                count = 1
            }
        }
        return target
    }

    fun singleNumber2(nums: IntArray): Int =
        nums.fold(0) { acc, i ->
            acc xor i
        }
}

fun main() {
    Solution().singleNumber(intArrayOf(
        1,1,2,2,3
    )).also {
        println(it)
    }

    Solution().singleNumber(intArrayOf(
        2,2,1
    )).also {
        println(it)
    }

    Solution().singleNumber(intArrayOf(
        4,1,2,1,2
    )).also {
        println(it)
    }


    Solution().singleNumber2(intArrayOf(
        1,1,2,2,3
    )).also {
        println(it)
    }

    Solution().singleNumber2(intArrayOf(
        2,2,1
    )).also {
        println(it)
    }

    Solution().singleNumber2(intArrayOf(
        4,1,2,1,2
    )).also {
        println(it)
    }
}