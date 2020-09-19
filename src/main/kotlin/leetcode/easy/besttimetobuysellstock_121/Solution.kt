package leetcode.easy.besttimetobuysellstock_121

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if(prices.size <= 1) return 0
        var min = prices[0]
        var profit = 0
        for(i in 1 until prices.size) {
            val price = prices[i]
            if(price < min) {
                min = price
                profit = maxOf(profit, 0)
            } else {
                profit = maxOf(profit, price - min)
            }
        }
        return profit
    }
}