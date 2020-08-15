package leetcode.easy.countlargestgroup_1399

class Solution {
    fun countLargestGroup(n: Int): Int {
        val sumCount = mutableMapOf<Int, Int>()
        for(i in 1..n) {
            var x = i
            var sum = 0
            while(x > 0) {
                sum += x % 10
                x /= 10
            }
            val count = sumCount.getOrDefault(sum, 0)
            sumCount[sum] = count + 1
        }
        var max = 0
        sumCount.values.forEach { v ->
            max = Math.max(max, v)
        }
        var count = 0
        sumCount.values.forEach { v->
            if(v == max) count++
        }
        return count
    }
}