package leetcode.easy.findluckyintinarray_1394

class Solution {
    fun findLucky(arr: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        arr.forEachIndexed { index, n ->
            val count = map.getOrDefault(n, 0)
            map[n] = count + 1
        }
        var max = -1
        map.entries.forEach { entry ->
            if(entry.key == entry.value) {
                max = maxOf(entry.key, max)
            }
        }
        return max
    }
}