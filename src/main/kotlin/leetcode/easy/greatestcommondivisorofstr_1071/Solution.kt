package leetcode.easy.greatestcommondivisorofstr_1071

class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        var s = if(str1.length > str2.length) str2 else str1
        while(s.isNotEmpty()) {
            val l = maxOf(str1.length, str2.length)
            for(i in 0 until l) {
                val c = s[i % s.length]
                if(i < str1.length) {
                    if(str1[i] != c) break
                    if(i == str1.length - 1 && i % s.length != s.length - 1) break
                }
                if(i < str2.length) {
                    if(str2[i] != c) break
                    if(i == str2.length - 1 && i % s.length != s.length - 1) break
                }
                if(i == l - 1) return s
            }
            s = s.substring(0, s.length - 1)
        }
        return s
    }
}