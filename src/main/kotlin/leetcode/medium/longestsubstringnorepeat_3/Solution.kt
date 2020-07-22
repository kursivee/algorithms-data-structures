package leetcode.medium.longestsubstringnorepeat_3

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.length == 1) return 1
        if(s.isEmpty()) return 0
        var longest = 1
        var l = 0
        var r = 1

        // use set to track the current substring
        val substring = HashSet<Char>()
        substring.add(s[l])

        while(r < s.length) {
            if(substring.contains(s[r])) {
                // search for matching character
                // remove previous elements since they should no longer
                // be considered as substring
                while(s[l] != s[r]) {
                    substring.remove(s[l++])
                }
                // remove the matching character from visited
                if(s[l] == s[r]) {
                    substring.remove(s[l++])
                }
            } else {
                substring.add(s[r++])
            }
            longest = Math.max(substring.count(), longest)
        }
        return longest
    }
}

fun main() {
    Solution().lengthOfLongestSubstring("abcabcbb").also {
        println(it)
    }
}