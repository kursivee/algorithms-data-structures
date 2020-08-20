package leetcode.easy.waterbottles_1518

class Solution {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var full = numBottles
        var empty = full
        var drank = full
        while(full > 0) {
            full = empty / numExchange
            drank += full
            empty = full + empty % numExchange
        }
        return drank
    }
}