package leetcode.easy.wordpattern_290

class Solution {
    fun wordPattern(pattern: String, str: String): Boolean {
        val map = mutableMapOf<Char, String>()
        val arr = str.split(" ")
        if(arr.size != pattern.length) return false
        for(i in pattern.indices) {
            if(map.contains(pattern[i])) {
                if(map[pattern[i]] != arr[i]) {
                    return false
                }
            } else {
                if(map.values.contains(arr[i])) return false
                map[pattern[i]] = arr[i]
            }
        }
        return true
    }
}