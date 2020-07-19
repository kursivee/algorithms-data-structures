package leetcode.medium.countnumberteams_1395

class Solution {
    fun numTeams(rating: IntArray): Int {
        var count = 0

        // dp array will keep track of how many elements are greater than it
        var dp = IntArray(rating.size)
        for(i in rating.indices) {
            for(j in i-1 downTo 0) {
                if(rating[i] < rating[j]) {
                    // hey i have one element that's greater than me, increment my count.
                    dp[i]++
                    /**
                     * ok here's the semi confusing part
                     * so we know that there's at least a subsequence of length 2 here
                     * since rating[i] < rating[j]
                     * Now since the dp array is keeping track of how many elements are greater than
                     * a given element, we can add the amount of elements greater than [j].
                     * since these elements are greater than [j] than we can also assume that it is greater than [i].
                     *
                     * Take the following snapshot:
                        assume we are now on rating[4]
                        rating = [2, 5, 3, 4, 1]
                        dp = [0, 0, 1, 1, 0]

                        we do check to see if rating[4] < rating[3] or 1 < 4
                        this is true so we can add the amount of elements less than 4 (tracked in dp[3])
                        in this case there is only one element which we can see is rating[1] or 5
                        and the subsequence we are now considering as a solution would be {1,4,5}

                        let's say rating = [6,5,3,4,1]
                        in this case dp[3] = 2, and the solution subsequences would be {1,4,5} and {1,4,6}
                     * */
                    count += dp[j]

                }
            }
        }

        /**
         *  We also need to consider where rating[i] > rating[j] > rating[k]
         * In order to do that we just need to do the same as previous except check if elements
         * are less than it
         */

        // Resetting the dp count since we don't need to keep track of the greater than elements
        dp = IntArray(rating.size)
        for(i in rating.indices) {
            for(j in i - 1 downTo 0) {
                if(rating[i] > rating[j]) {
                    dp[i]++
                    count += dp[j]
                }
            }
        }
        return count
    }
}

fun main() {
    Solution().numTeams(intArrayOf(2,5,3,4,1)).also {
        println(it)
    }
}