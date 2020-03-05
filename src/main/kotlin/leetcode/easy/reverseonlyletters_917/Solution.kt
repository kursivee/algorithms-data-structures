package leetcode.easy.reverseonlyletters_917

// https://leetcode.com/problems/reverse-only-letters/
class Solution {
    fun reverseOnlyLetters(S: String): String {
        var l = 0
        var r = S.length - 1
        val arr = S.toCharArray()
        while(l < r) {
            val left = arr[l]
            val right = arr[r]
            if(left.isLetter() && right.isLetter()) {
                arr[l++] = right
                arr[r--] = left
            } else {
                if(!left.isLetter()) l++
                if(!right.isLetter()) r--
            }
        }
        return arr.joinToString("")
    }
}

fun main() {
    Solution().reverseOnlyLetters("ab-cd").also {
        println(it)
    }

    Solution().reverseOnlyLetters("a-bC-dEf-ghIj").also {
        println(it)
    }

    Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!").also {
        println(it)
    }
}