package leetcode.easy.validanagram_242

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        val mapS = mutableMapOf<Char, Int>()
        val mapT = mutableMapOf<Char, Int>()
        s.forEach { c ->
            val count = mapS.getOrDefault(c, 0)
            mapS[c] = count + 1
        }
        t.forEach { c ->
            val count = mapT.getOrDefault(c, 0)
            mapT[c] = count + 1
        }
        mapS.entries.forEach { (key, value) ->
            if(mapT[key] != value) {
                return false
            }
        }
        return true
    }
}