package leetcode.easy.findthediff_389

class Solution {
    fun findTheDifference(s: String, t: String): Char {
        val map = mutableMapOf<Char, Int>()
        s.forEach { c ->
            val count = map.getOrDefault(c, 0)
            map[c] = count + 1
        }

        t.forEach { c ->
            if(!map.contains(c)) return c
            val count = map[c]!!
            if(count == 0) return c
            map[c] = count - 1
        }
        return ' '
    }
}