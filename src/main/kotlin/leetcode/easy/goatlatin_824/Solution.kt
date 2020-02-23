package leetcode.easy.goatlatin_824

// https://leetcode.com/problems/goat-latin/
class Solution {
    fun toGoatLatin(S: String): String {
        var res = ""
        val words = S.split(" ")
        words.forEachIndexed { i, word ->
            var newS: String = if(word[0].isVowel()) {
                word + "ma"
            } else {
                word.substring(1 until word.length) + word[0] + "ma"
            }
            repeat(i + 1) {
                newS += 'a'
            }
            res += " $newS"
        }
        return res.trim()
    }

    private fun Char.isVowel(): Boolean {
        return  listOf('a', 'e', 'i', 'o', 'u').contains(this.toLowerCase())
    }
}

fun main() {
    Solution().toGoatLatin("I speak Goat Latin").also {
        println(it)
        println(it == "Imaa peaksmaaa oatGmaaaa atinLmaaaaa")
    }

    Solution().toGoatLatin("The quick brown fox jumped over the lazy dog").also {
        println(it)
        println(it == "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa")
    }
}