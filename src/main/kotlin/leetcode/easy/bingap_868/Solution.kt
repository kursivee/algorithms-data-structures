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

    fun binaryGap2(N: Int): Int {
        var x = N
        var count = 0
        var curr = false
        var max = 0
        while(x != 0) {
            if(x % 2 == 1) {
                if(curr) {
                    count++
                    max = Math.max(max, count)
                    count = 0
                } else {
                    curr = true
                }
            } else if(curr) count++
            x /= 2
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

    println()

    Solution().binaryGap2(22).also {
        println(it)
    }

    Solution().binaryGap2(5).also {
        println(it)
    }

    Solution().binaryGap2(6).also {
        println(it)
    }

    Solution().binaryGap2(8).also {
        println(it)
    }
}