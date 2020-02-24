package leetcode.easy.maxnumberballoons_1189

// https://leetcode.com/problems/maximum-number-of-balloons/
class Solution {
    private val map = mutableMapOf(
        'b' to 0,
        'a' to 0,
        'l' to 0,
        'o' to 0,
        'n' to 0
    )

    fun maxNumberOfBalloons(text: String): Int {
        text.forEach {
            if(map.containsKey(it)) {
                map[it] = map[it]!! + 1
            }
        }
        var min = Int.MAX_VALUE
        map.entries.forEach {
            min = if(it.key == 'l' || it.key == 'o') {
                Math.min(min, it.value / 2)
            } else {
                Math.min(min, it.value)
            }
        }
        return min
    }
}

fun main() {
    Solution().maxNumberOfBalloons("nlaebolko").also {
        println(it)
    }

    Solution().maxNumberOfBalloons("loonbalxballpoon").also {
        println(it)
    }

    Solution().maxNumberOfBalloons("leetcode").also {
        println(it)
    }
}