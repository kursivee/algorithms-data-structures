package leetcode.easy.makethestringreat_1544

import java.util.*

class Solution {
    fun makeGood(s: String): String {
        if(s.isEmpty()) return ""
        val stack = ArrayDeque<Char>()
        s.forEach { char ->
            if(stack.isEmpty()) { stack.push(char) }
            else if(stack.peek().equals(char, true)) {
                if((stack.peek().isUpperCase() && char.isLowerCase()) || (stack.peek().isLowerCase() && char.isUpperCase())) {
                    stack.pop()
                } else {
                    stack.push(char)
                }
            } else {
                stack.push(char)
            }
        }
        return stack.joinToString("").reversed()
    }
}