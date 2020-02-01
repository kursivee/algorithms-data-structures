package leetcode.easy.decryptstringalphatoint_1309

// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
class Solution {
    private val map = mapOf(
        "1" to "a",
        "2" to "b",
        "3" to "c",
        "4" to "d",
        "5" to "e",
        "6" to "f",
        "7" to "g",
        "8" to "h",
        "9" to "i",
        "10#" to "j",
        "11#" to "k",
        "12#" to "l",
        "13#" to "m",
        "14#" to "n",
        "15#" to "o",
        "16#" to "p",
        "17#" to "q",
        "18#" to "r",
        "19#" to "s",
        "20#" to "t",
        "21#" to "u",
        "22#" to "v",
        "23#" to "w",
        "24#" to "x",
        "25#" to "y",
        "26#" to "z"
    )

    fun freqAlphabets(s: String): String {
        var ans = ""
        var index = 0
        while(index < s.length) {
            val isBang: Boolean = kotlin.runCatching { s[index + 2] == '#' }.getOrNull() ?: false
            if(isBang) {
                ans += map[s.substring(index, index+3)]
                index += 3
            } else {
                ans += map[s[index++].toString()]
            }
        }
        return ans
    }
}

fun main() {
    Solution().freqAlphabets("1326#").also { println(it) }
    Solution().freqAlphabets("10#11#12").also { println(it) }
    Solution().freqAlphabets("25#").also { println(it) }
}