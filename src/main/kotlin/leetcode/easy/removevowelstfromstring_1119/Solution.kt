package leetcode.easy.removevowelstfromstring_1119

class Solution {
    fun removeVowels(S: String): String {
        return S.filter { c ->
            !charArrayOf('a', 'e', 'i', 'o', 'u').contains(c)
        }
    }
}