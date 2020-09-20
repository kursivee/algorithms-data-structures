package leetcode.easy.sumofalloddlengthsubarrays_1588

class Solution {
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        var sum = 0
        for(i in arr.indices) {
            var oddSum = 0
            for((count, j) in (i until arr.size).withIndex()) {
                oddSum += arr[j]
                if((count + 1) % 2 == 1) {
                    sum += oddSum
                }
            }
        }
        return sum
    }
}