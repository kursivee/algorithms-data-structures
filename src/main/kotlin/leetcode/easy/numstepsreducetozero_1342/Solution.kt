package leetcode.easy.numstepsreducetozero_1342

class Solution {
    fun numberOfSteps (num: Int): Int {
        var n = num
        var count = 0
        while(n != 0) {
            if(n % 2 == 0) {
                n /= 2
            } else {
                n--
            }
            count++
        }
        return count
    }
}