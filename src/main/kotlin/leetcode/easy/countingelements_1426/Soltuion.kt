package leetcode.easy.countingelements_1426

class Solution {
    fun countElements(arr: IntArray): Int {
        val set = mutableSetOf<Int>()
        arr.forEach { n ->
            set.add(n)
        }
        var count = 0
        for(n in arr) {
            if(set.contains(n + 1)) count++
        }
        return count
    }
}