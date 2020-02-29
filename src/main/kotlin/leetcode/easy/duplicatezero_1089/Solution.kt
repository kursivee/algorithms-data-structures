package leetcode.easy.duplicatezero_1089

// https://leetcode.com/problems/duplicate-zeros/
class Solution {
    fun duplicateZeros(arr: IntArray): IntArray {
        var i = 0
        while(i < arr.size) {
            if(arr[i] == 0) {
                var replace = -1
                i++
                for(j in i until arr.size) {
                    var tmp = arr[j]
                    arr[j] = if(replace == -1) 0 else replace
                    replace = tmp
                }
            }
            i++
        }
        return arr
    }
}

fun main() {
    Solution().duplicateZeros(intArrayOf(
        1,0,2,3,0,4,5,0
    )).also {
        println(it.joinToString(", "))
        println(it.contentEquals(intArrayOf(1,0,0,2,3,0,0,4)))
    }


    Solution().duplicateZeros(intArrayOf(
        1,2,3
    )).also {
        println(it.joinToString(", "))
    }
}