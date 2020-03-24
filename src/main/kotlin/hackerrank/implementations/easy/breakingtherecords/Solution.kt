package hackerrank.implementations.easy.breakingtherecords

class Solution {
    fun breakingRecords(scores: Array<Int>): Array<Int> {
        var max = scores[0]
        var min = scores[0]
        var maxCount = 0
        var minCount = 0
        for(i in 1 until scores.size) {
            val s = scores[i]
            if(s > max) {
                maxCount++
                max = s
            }
            if(s < min) {
                minCount++
                min = s
            }
        }
        return arrayOf(maxCount, minCount)
    }
}

fun main() {
    Solution().breakingRecords(
        arrayOf(3,4,21,36,10,28,35,5,24,42)
    ).also {
        println(it.joinToString(", "))
    }
}