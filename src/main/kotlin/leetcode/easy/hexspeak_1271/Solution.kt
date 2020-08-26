package leetcode.easy.hexspeak_1271

class Solution {
    fun toHexspeak(num: String): String {
        val s = num.toLong().toString(16)
            .replace("1", "I")
            .replace("0", "O")
            .toUpperCase()
        val chars = "ABCDEFIO".toCharArray()
        for(c in s) {
            if(!chars.contains(c)) return "ERROR"
        }
        return s
    }
}