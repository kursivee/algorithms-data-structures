package leetcode.easy.flippingimage_832

import kotlin.math.abs

// https://leetcode.com/problems/flipping-an-image/
class Solution {
    fun flipAndInvertImage(arr: Array<IntArray>): Array<IntArray> {
        val ans = Array(arr.size) {
            IntArray(arr[0].size)
        }
        arr.forEachIndexed { index, ints ->
            ans[index] = ints.flip().invert()
        }
        return ans
    }

    private fun IntArray.flip(): IntArray {
        val arr = IntArray(size)
        for(i in size - 1 downTo 0) {
            arr[i] = get(abs(size - i - 1))
        }
        return arr
    }
    private fun IntArray.invert(): IntArray {
        val arr = IntArray(size)
        forEachIndexed { index, i ->
            arr[index] = if(i == 0) { 1 } else 0
        }
        return arr
    }
}

fun main() {
    Solution().flipAndInvertImage(arrayOf(
        intArrayOf(1,1,0),
        intArrayOf(1,0,1),
        intArrayOf(0,0,0)
    )).also {
        it.log()
    }
}

fun Array<IntArray>.log() {
    forEach {  arr ->
        println(arr.joinToString(", "))
    }
}