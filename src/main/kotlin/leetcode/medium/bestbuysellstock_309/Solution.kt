package leetcode.medium.bestbuysellstock_309

class Solution {
    /*
    find the max profit.
    break down the problem and start simple.
    given an element, we can either buy or sell.

    need to track the max profit based on whether or not we bought or sold the stock
     */
    fun maxProfit(prices: IntArray): Int {
        val dp = IntArray(prices.size + 2)
        for(i in prices.size - 1 downTo 0) {
            var maxProfit = Int.MIN_VALUE
            for(j in i + 1 until prices.size) {
                val profit = prices[j] - prices[i]
                /*
                    this for loop is checking what happens if we sell on j
                    we're checking against profit + dp[j + 2]
                    we're getting the max profit of j + 2 because we have a 1 day cooldown after we sell
                    doing j + 1 means being able to sell immediately
                 */
                maxProfit = Math.max(maxProfit, profit + dp[j + 2])
            }
            dp[i] = Math.max(maxProfit, dp[i + 1])
        }
        return dp[0]
    }
}

fun main() {
    Solution().maxProfit(intArrayOf(1,2,3,0,2)).also {
        println(it)
    }
}