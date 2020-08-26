package leetcode.medium.minimumcostfortickets_983

class Solution {
    /*
    TAG: Dynamic Programming
    Inution:

    Bottom Up approach

    We are building the solution by finding the minimum amount spent on ANY given day
    This allows us to track the historical price and now we can do i - x where x the day denomination from 1,7,30
    This will allow us to determine what the new value would be if we bought an x ticket on a given day

    e.g
    Given days [1,2,..24.,30,31]
    At 9

    i - x where x == 1, it would give us 30.
    Now we can take the price at 30 and add the cost of x
    ans = price(30) + cost(x)

    i - x where x == 7, it would give us 24.
    Now we can take the price at 24 and add the cost of x
    ans = price(24) + cost(x)

    i - x where x == 30, it would give us 1.
    Now we can take the price at 1 and add the cost of x
    ans = price(1) + cost(x)

    The current value would then equal the minimum of all different day denominations

    */
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val dp = IntArray(365 + 1)
        for(i in 1 .. 365) {
            if(days.contains(i)) {
                dp[i] = minOf(
                    dp[i - 1] + costs[0],
                    dp[maxOf(0, i - 7)] + costs[1],
                    dp[maxOf(0, i - 30)] + costs[2]
                )
            } else {
                dp[i] = dp[i - 1]
            }
        }
        return dp[365]
    }
}