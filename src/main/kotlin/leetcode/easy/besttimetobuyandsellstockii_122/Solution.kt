package leetcode.easy.besttimetobuyandsellstockii_122

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var max = 0
        for(i in 0 until prices.size - 1) {
            val diff = prices[i + 1] - prices[i]
            if(diff > 0) {
                max += diff
            }
        }
        return max
    }
}