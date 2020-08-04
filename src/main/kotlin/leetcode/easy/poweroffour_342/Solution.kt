package leetcode.easy.poweroffour_342

class Solution {
    fun isPowerOfFour(num: Int): Boolean {
        var n = num
        while(n > 1) {
            if(n % 4 != 0) return false
            n /= 4
        }
        return n == 1
    }
}