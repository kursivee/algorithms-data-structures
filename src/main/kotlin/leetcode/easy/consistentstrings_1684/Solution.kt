package leetcode.easy.consistentstrings_1684

class Solution {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        var count = 0
        val arr = IntArray(26)
        allowed.forEach { c ->
            arr[c - 'a'] = 1
        }
        for(word in words) {
            var bool = true
            for(c in word) {
                if(arr[c - 'a'] == 0) {
                    bool = false
                    break
                }
            }
            if(bool) count++
        }
        return count
    }
}