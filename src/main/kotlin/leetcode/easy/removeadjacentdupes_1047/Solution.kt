package leetcode.easy.removeadjacentdupes_1047

import java.util.*

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
class Solution {

    fun removeDuplicates(S: String): String {
        val stack = ArrayDeque<Char>()
        S.forEach {
            if(stack.isEmpty()) {
                stack.push(it)
            } else if(stack.peek() == it) {
                stack.pop()
            } else {
                stack.push(it)
            }
        }
        return stack.joinToString("").reversed()
    }
}

fun main() {
    Solution().removeDuplicates("abbaca").also { println(it) }
}