package leetcode.easy.differencebetweenbus_1184

class Solution {
    fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
        var i = start
        var clockSum = 0
        run loop@{
            repeat(distance.size) {
                val index = i++ % distance.size
                if(index == destination) return@loop
                clockSum += distance[index]
            }
        }
        var counterSum = 0
        i = start - 1

        run loop@{
            repeat(distance.size) {
                val index = ((i-- % distance.size) + distance.size) % distance.size
                counterSum += distance[index]
                if(index == destination) return@loop
            }
        }
        return minOf(clockSum, counterSum)
    }
}