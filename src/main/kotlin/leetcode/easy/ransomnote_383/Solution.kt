package leetcode.easy.ransomnote_383

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val arr = IntArray(26)
        ransomNote.forEach { c ->
            arr[c - 'a'] = arr[c - 'a'] - 1
        }
        magazine.forEach { c ->
            arr[c - 'a'] = arr[c - 'a'] + 1
        }
        arr.forEach { count ->
            if(count < 0) return false
        }
        return true
    }
}