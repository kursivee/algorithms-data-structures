package leetcode.hard.wordbreak2_140

class Solution {
    /*
    iterate and when we find a match
    choose to use the word
    or choose to not use the word

    terminate if s is empty

    this ^ is too slow

    so we need dynamic programming

    given
    input: aaaa, dict: [a, aa, aaa, aaaa]
    f(aaaa) = a + f(aaa)
    f(aaa) = a + f(aa)
    f(aa) = a + f(a)
    f(a) = a

    becomes
    f(aaaa) = f(a) + f(aaa)
    f(aaa) = f(a) + f(aa)
    f(aa) = f(a) + f(a)
    f(a) = a

    we need to cache f(a*) so that when we backstract we already have
    f(a) <--cached + f(a*) <-- cached

    */
    val cache = mutableMapOf<String, List<String>>()

    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        //catsdog
        if(s.isEmpty()) return listOf("")
        if(cache.contains(s)) return cache[s]!!
        val ans = mutableListOf<String>()
        var word = ""
        for(i in s.indices) {
            word += s[i]
            if(wordDict.contains(word)) {
                val list = wordBreak(s.substring(i + 1, s.length), wordDict)
                for(w in list) {
                    ans.add("$word $w".trim())
                }
            }
        }
        cache[s] = ans
        return ans
    }
}

fun main() {
    Solution().wordBreak("catsanddog", listOf("cat", "cats", "and", "sand", "dog"))
        .also { println(it.joinToString(", ")) }

    val longString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    val dict = listOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
    Solution().wordBreak(longString, dict).also {
        println(it.joinToString(", "))
    }
}