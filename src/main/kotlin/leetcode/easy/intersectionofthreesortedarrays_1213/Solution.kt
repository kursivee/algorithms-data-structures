package leetcode.easy.intersectionofthreesortedarrays_1213

class Solution {
    fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> {
        val map = mutableMapOf<Int, Int>()
        val max = Math.max(Math.max(arr1.size, arr2.size), arr3.size)
        for(i in 0 until max) {
            if(i < arr1.size) {
                var count = map.getOrDefault(arr1[i], 0)
                map[arr1[i]] = count + 1
            }
            if(i < arr2.size) {
                var count = map.getOrDefault(arr2[i], 0)
                map[arr2[i]] = count + 1
            }
            if(i < arr3.size) {
                var count = map.getOrDefault(arr3[i], 0)
                map[arr3[i]] = count + 1
            }
        }
        return map.filter { entry ->
            entry.value == 3
        }.keys.toList()
    }
}