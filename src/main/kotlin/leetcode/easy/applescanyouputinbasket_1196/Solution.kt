package leetcode.easy.applescanyouputinbasket_1196

class Solution {
    fun maxNumberOfApples(arr: IntArray): Int {
        val list = arr.toMutableList()
        var sum = list.sum()
        while(sum > 5000) {
            val max = list.max()!!
            sum -= max
            list.remove(max)
        }
        return list.size
    }
}