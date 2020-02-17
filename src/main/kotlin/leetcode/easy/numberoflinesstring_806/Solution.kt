package leetcode.easy.numberoflinesstring_806

// https://leetcode.com/problems/number-of-lines-to-write-string/
class Solution {
    fun numberOfLines(widths: IntArray, S: String): IntArray {
        val sum = S.fold(0) { acc, i ->
            val x = widths[i - 'a']
            val remainder = acc % 100
            if(remainder + x > 100) {
                acc + 100 - remainder + x
            } else {
                acc + x
            }
        }
        return intArrayOf((sum / 100 + 1), sum % 100)
    }
}

fun main() {
    Solution().numberOfLines(intArrayOf(
        10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10
    ), "abcdefghijklmnopqrstuvwxyz").also {
        println(it.joinToString(", ") == "3, 60")
    }

    Solution().numberOfLines(intArrayOf(
        4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10
    ), "bbbcccdddaaa").also {
        println(it.joinToString(", ") == "2, 4")
    }

    Solution().numberOfLines(intArrayOf(
        7,5,4,7,10,7,9,4,8,9,6,5,4,2,3,10,9,9,3,7,5,2,9,4,8,9
    ), "zlrovckbgjqofmdzqetflraziyvkvcxzahzuuveypqxmjbwrjvmpdxjuhqyktuwjvmbeswxuznumazgxvitdrzxmqzhaaudztgie").also {
        println(it.joinToString(", ") == "7, 69")
    }
}