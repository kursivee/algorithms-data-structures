package leetcode.easy.lengthoflastword_58

class Solution {
    fun lengthOfLastWord(s: String): Int {
        return s.trim().split(" ").last().length
    }
}