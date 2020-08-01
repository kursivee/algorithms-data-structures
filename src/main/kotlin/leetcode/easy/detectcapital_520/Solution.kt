package leetcode.easy.detectcapital_520

class Solution {
    /*
    get all the capital counts
    if count == 1
    if [0] is capital return true
    if count == word.size return true
    if count == 0 return true
    return false
    */

    fun detectCapitalUse(word: String): Boolean {
        var count = 0
        for(char in word) {
            if(char.isUpperCase()) {
                count++
            }
        }
        if(count == 1) {
            if(word[0].isUpperCase()) return true
        }
        if(count == word.length) return true
        if(count == 0) return true
        return false
    }
}

fun main() {
    println(Solution().detectCapitalUse("USA"))
    println(Solution().detectCapitalUse("FlaG"))
    println(Solution().detectCapitalUse("usa"))
}