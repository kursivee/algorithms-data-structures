package leetcode.medium.carpooling_1094

class Solution {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val add = mutableMapOf<Int, Int>()
        val leave = mutableMapOf<Int, Int>()
        val keys = sortedSetOf<Int>()
        trips.forEach { trip ->
            val passengers = trip[0]
            val addCount = add.getOrDefault(trip[1], 0)
            add[trip[1]] = addCount + passengers
            val leaveCount = leave.getOrDefault(trip[2], 0)
            leave[trip[2]] = leaveCount + passengers
            keys.add(trip[1])
            keys.add(trip[2])
        }
        var cap = 0
        keys.forEach { key ->
            cap += add[key] ?: 0
            cap -= leave[key] ?: 0
            if(cap > capacity) return false
        }
        return true
    }
}