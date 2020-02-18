package leetcode.easy.keyboardrow_500

// https://leetcode.com/problems/keyboard-row/
class Solution {
    private val r1 = arrayOf('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p')
    private val r2 = arrayOf('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l')
    private val r3 = arrayOf('z', 'x', 'c', 'v', 'b', 'n', 'm')
    fun findWords(words: Array<String>): Array<String> {
        val list = mutableListOf<String>()
        words.forEach outer@ { s ->
            var cat = 0
            s.forEach {
                if(r1.contains(it)) {
                    if(cat != 0 && cat != 1) {
                        return@outer
                    } else cat = 1
                } else if(r2.contains(it)) {
                    if(cat != 0 && cat != 2) {
                        return@outer
                    } else cat = 2
                } else if(r3.contains(it)) {
                    if(cat != 0 && cat != 3) {
                        return@outer
                    } else cat = 3
                }
            }
            list.add(s)
        }
        return list.toTypedArray()
    }
}

fun main() {
    Solution().findWords(arrayOf(
        "Hello", "Alaska", "Dad", "Peace"
    )).also { println(it.joinToString(", ")) }
}