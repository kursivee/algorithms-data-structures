package leetcode.easy.distributecandiestopeople_1103

// https://leetcode.com/problems/distribute-candies-to-people/
class Solution {
    fun distributeCandies(candies: Int, num_people: Int): IntArray {
        val arr = IntArray(num_people)
        var i = 1
        var c = candies
        while(c > 0) {
            arr[(i-1) % num_people] += Math.min(i, c)
            c -= i++
        }
        return arr
    }
}

fun main() {
    Solution().distributeCandies(
        7, 4
    ).also {
        println(it.joinToString(", "))
    }

    Solution().distributeCandies(
        10, 3
    ).also {
        println(it.joinToString(", "))
    }
}