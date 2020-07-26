package leetcode.medium.numbersubarrayoddsum_1524

class Solution {

    val mod = 1000000000 + 7

    fun numOfSubarrays(arr: IntArray): Int {
        var countEvenSum = 1 // due to zero being first sum
        var countOddSum = 0
        var ans = countOddSum
        var sum = 0
        // O(n)
        for(i in arr) {
            sum += i
            ans = if(sum % 2 == 1) {
                countOddSum++
                (ans + countEvenSum) % mod
            } else {
                countEvenSum++
                (ans + countOddSum) % mod
            }
        }
        return ans
    }

}

fun main() {
    Solution().numOfSubarrays(intArrayOf(1,3,5)).also {
        println(it)
    }
}