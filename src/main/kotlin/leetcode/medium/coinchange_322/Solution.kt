package leetcode.medium.coinchange_322

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) {
            amount + 1
        }
        dp[0] = 0
        for(i in 1 .. amount) {
            coins.forEach { coin ->
                if(i - coin >= 0)
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i])
            }
        }
        return if(dp[amount] == amount + 1) -1 else dp[amount]
    }
}