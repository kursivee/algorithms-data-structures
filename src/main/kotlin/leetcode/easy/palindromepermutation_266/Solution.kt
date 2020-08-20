package leetcode.easy.palindromepermutation_266

class Solution {
    fun canPermutePalindrome(s: String): Boolean {
        val map = mutableMapOf<Char, Int>()
        s.forEach { c ->
            val count = map.getOrDefault(c, 0)
            map[c] = count + 1
        }
        var oddCount = 0
        map.values.forEach { value ->
            if(value % 2 == 1) oddCount++
            if(oddCount > 1) return false
        }
        return true
    }
}