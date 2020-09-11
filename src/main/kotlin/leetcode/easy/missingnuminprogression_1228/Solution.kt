package leetcode.easy.missingnuminprogression_1228

class Solution {
    fun missingNumber(arr: IntArray): Int {
        var minDiff = arr[1] - arr[0]
        for(i in 1 until arr.size - 1) {
            val diff = arr[i + 1] - arr[i]
            if(Math.abs(diff) < Math.abs(minDiff)) {
                return arr[i - 1] + diff
            }
            if(Math.abs(diff) > Math.abs(minDiff)) {
                return arr[i] + minDiff
            }
        }
        return arr[0]
    }
}