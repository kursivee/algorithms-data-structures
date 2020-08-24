package leetcode.hard.reducingdishes_1402

import java.util.*

class Solution {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        /*
        1, 2, 3, 4,5,6
        -3,-2,-1,0,3,5

        30,15,0,-3,-2,-3

        sort negatives
        sort pos
        get sum of pos

        loop
        add -
        check if less or greater

        */
        satisfaction.sort()
        if(satisfaction.max()!! <= 0) return 0
        val pos = ArrayDeque<Int>()
        val neg = mutableListOf<Int>()
        satisfaction.forEach { n ->
            if(n < 0) neg.add(n)
            else pos.add(n)
        }
        var sum = pos.timesSum()
        for(i in neg.size - 1 downTo 0) {
            pos.addFirst(neg[i])
            sum = Math.max(sum, pos.timesSum())
        }
        return sum

    }

    private fun ArrayDeque<Int>.timesSum(): Int {
        var sum = 0
        this.forEachIndexed { index, n ->
            sum += n * (index + 1)
        }
        return sum
    }

    fun maxSatisfactionOptimized(satisfaction: IntArray): Int {
        var suffixSum = 0
        var sum = 0
        satisfaction.sort()
        for(i in satisfaction.indices.reversed()) {
            suffixSum += satisfaction[i]
            if(suffixSum <= 0) break
            sum += suffixSum
        }
        return sum

    }
}