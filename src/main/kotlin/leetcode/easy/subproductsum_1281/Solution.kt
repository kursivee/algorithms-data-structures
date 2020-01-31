package leetcode.easy.subproductsum_1281

// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/submissions/
class Solution {
    fun subtractProductAndSum(n: Int = 234): Int {
        var ans = 1
        n.toString().forEach {
            ans *= it.toString().toInt()
        }
        n.toString().forEach {
            ans -= it.toString().toInt()
        }
        return ans
    }
}

fun main() {
    Solution().subtractProductAndSum().also { println(it) }
}