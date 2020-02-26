package leetcode.easy.reshapematrix_566

// https://leetcode.com/problems/reshape-the-matrix/
class Solution {
    fun matrixReshape2(nums: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        if(nums.isEmpty() || r * c > nums.size * nums[0].size) return nums
        var i2 = 0
        var j2 = 0
        val ans = Array(r) {
            IntArray(c)
        }
        for(i in nums.indices) {
            for(j in nums[0].indices) {
//                println("($i2, $j2) ($i, $j)")
                ans[i2 % r][j2++ % c] = nums[i][j]
                if(j2 % c == 0) i2++
            }
        }
        return ans
    }

    fun matrixReshape(nums: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        if(nums.isEmpty() || r * c > nums.size * nums[0].size) return nums
        var count = 0
        val ans = Array(r) {
            IntArray(c)
        }
        for(i in nums.indices) {
            for(j in nums[0].indices) {
//                println("($i2, $j2) ($i, $j)")
                ans[count / c][count % c] = nums[i][j]
                count++
            }
        }
        return ans
    }
}

fun main() {
    Solution().matrixReshape(
        arrayOf(
            intArrayOf(1,2),
            intArrayOf(3,4)
        ), 1, 4
    ).also {
        it.forEach {
            println(it.joinToString(" "))
        }
    }

    Solution().matrixReshape(
        arrayOf(
            intArrayOf(1,2),
            intArrayOf(3,4)
        ), 4, 1
    ).also {
        it.forEach {
            println(it.joinToString(" "))
        }
    }

    Solution().matrixReshape(
        arrayOf(
            intArrayOf(1,2,3,4)
        ), 2, 2
    ).also {
        it.forEach {
            println(it.joinToString(" "))
        }
    }

    Solution().matrixReshape(
        arrayOf(
            intArrayOf(1,2),
            intArrayOf(3,4)
        ), 2, 4
    ).also {
        it.forEach {
            println(it.joinToString(" "))
        }
    }
}