package leetcode.easy.canmakearithmeticprogresssion_1502

class Solution {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        arr.sort()
        var target = arr[1] - arr[0]
        for(i in 2 until arr.size) {
            val diff = arr[i] - arr[i - 1]
            if(diff != target) return false
            target = diff
        }
        return true
    }
}