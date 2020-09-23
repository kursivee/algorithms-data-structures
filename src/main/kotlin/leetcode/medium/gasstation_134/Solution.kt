package leetcode.medium.gasstation_134

class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        loop@for(i in gas.indices) {
            var sum = 0
            for(j in i until (gas.size + i + 1)) {
                sum += gas[j % gas.size]
                sum -= cost[j % gas.size]
                if(sum < 0) continue@loop
            }
            return i
        }
        return -1
    }
}