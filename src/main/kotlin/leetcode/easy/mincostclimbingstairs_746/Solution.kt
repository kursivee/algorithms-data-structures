package leetcode.easy.mincostclimbingstairs_746

class Solution {
    /*
    Tag: DP
    Intuition:
    1, 100, 1, 1, 1, 100, 1, 1, 100, 1
    1, 100, 2, 3, 3, 103, 4, 5, 104, 6

    10, 15, 20
    10, 15, 30

    get the min cost it'll take to get to the i step
    by looking at the min cost it takes to get to i - 1 and i - 2
    if at the beginning then all costs are 0
    calc the min of the size - 2 || size - 1 element
    */
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(cost.size)
        for(i in cost.indices) {
            val step1 = if(i - 1 < 0) 0 else dp[i - 1]
            val step2 = if(i - 2 < 0) 0 else dp[i - 2]
            dp[i] = Math.min(cost[i] + step1, cost[i] + step2)
        }
        return Math.min(dp[cost.size - 1], dp[cost.size - 2])
    }
}