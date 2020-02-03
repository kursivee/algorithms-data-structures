package leetcode.easy.distringmatch_942

// https://leetcode.com/problems/di-string-match/
class Solution {
    fun diStringMatch(s: String): IntArray {
        val arr = IntArray(s.length + 1)
        var min = 0
        var max = s.length
        var index = 0
        for(i in s) {
            if(i == 'I') {
                arr[index] = min++
            } else {
                arr[index] = max--
            }
            index++
        }
        arr[index] = min
        return arr
    }
}

fun main() {
    Solution().diStringMatch("I").also { println(it.joinToString(", ") == "0, 1") }
    Solution().diStringMatch("D").also { println(it.joinToString(", ") == "1, 0") }
    Solution().diStringMatch("II").also { println(it.joinToString(", ") == "0, 1, 2") }
    Solution().diStringMatch("DD").also { println(it.joinToString(", ") == "2, 1, 0") }
    Solution().diStringMatch("ID").also { println(it.joinToString(", ") == "0, 2, 1") }
    Solution().diStringMatch("IDID").also { println(it.joinToString(", ") == "0, 4, 1, 3, 2") }
    Solution().diStringMatch("III").also { println(it.joinToString(", ") == "0, 1, 2, 3") }
    Solution().diStringMatch("DDI").also { println(it.joinToString(", ") == "3, 2, 0, 1") }
}