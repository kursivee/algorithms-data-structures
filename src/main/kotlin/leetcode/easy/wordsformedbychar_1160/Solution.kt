package leetcode.easy.wordsformedbychar_1160

// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
class Solution {
    fun countCharacters(words: Array<String>, chars: String): Int {
        var count = 0
        words.forEach {  word ->
            val list = chars.toMutableList()
            var sCount = 0
            for(char in word) {
                if(!list.remove(char)) {
                    sCount = 0
                    break
                } else {
                    sCount++
                }
            }
            count += sCount
        }
        return count
    }
}

fun main() {
    Solution().countCharacters(arrayOf(
        "cat","bt","hat","tree"
    ), "atach").also { println(it) }

    Solution().countCharacters(arrayOf(
        "hello","world","leetcode"
    ), "welldonehoneyr").also { println(it) }
}