package leetcode.easy.bingap_868

// https://leetcode.com/problems/binary-gap/
class Solution {
    fun binaryGap(N: Int): Int {
        val s = Integer.toBinaryString(N)
        var max = 0
        var currIndex = -1
        s.forEachIndexed { index, c ->
            if(c == '1') {
                if(currIndex == -1) {
                    currIndex = index
                } else {
                    max = Math.max(max, index - currIndex)
                    currIndex = index
                }
            }
        }
        return max
    }
}

fun main() {
    Solution().binaryGap(22).also {
        println(it)
    }

    Solution().binaryGap(5).also {
        println(it)
    }

    Solution().binaryGap(6).also {
        println(it)
    }

    Solution().binaryGap(8).also {
        println(it)
    }
}