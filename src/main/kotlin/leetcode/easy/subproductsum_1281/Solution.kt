package leetcode.easy.subproductsum_1281

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