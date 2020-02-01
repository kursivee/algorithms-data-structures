package leetcode.easy.uniqueintsumzero_1304

// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/submissions/
class Solution {
    fun sumZero(n: Int): IntArray {
        val arr = IntArray(n)
        var i = 0
        var count = 1
        if(n == 1) {
            arr[i] = 0
        } else {
            repeat(n / 2) {
                arr[i++] = count
                arr[i++] = count++ * -1
            }
            if(n % 2 == 1) {
                arr[i] = 0
            }
        }
        return arr
    }
}

fun main() {
    Solution().sumZero(3).also { println(it.joinToString(", ")) }
    Solution().sumZero(4).also { println(it.joinToString(", ")) }
    Solution().sumZero(5).also { println(it.joinToString(", ")) }
}