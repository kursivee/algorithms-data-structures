package leetcode.easy.finalpriceswithdiscountinshop_1475

class Solution {
    fun finalPrices(prices: IntArray): IntArray {
        var arr = IntArray(prices.size)
        for(i in 0 until prices.size) {
            var min = 0
            for(j in i + 1 until prices.size) {
                if(prices[j] <= prices[i]) {
                    min = prices[j]
                    break
                }
            }
            arr[i] = prices[i] - min
        }
        return arr
    }
}