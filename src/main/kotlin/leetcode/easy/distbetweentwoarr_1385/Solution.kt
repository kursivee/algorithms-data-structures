package leetcode.easy.distbetweentwoarr_1385

class Solution {
    fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        var count = arr1.size
        for(i in arr1) {
            for(j in arr2) {
                if(Math.abs(i - j) <= d) {
                    count--
                    break
                }
            }
        }
        return count
    }
}