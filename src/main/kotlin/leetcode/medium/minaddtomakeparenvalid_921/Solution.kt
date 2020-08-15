package leetcode.medium.minaddtomakeparenvalid_921

import java.util.*

class Solution {
    fun minAddToMakeValid(S: String): Int {
        var count = 0
        val stack = ArrayDeque<Char>()
        S.forEach { c ->
            if(c == '(') stack.push(c)
            else {
                if(stack.isEmpty()) {
                    count++
                } else stack.pop()
            }
        }
        return count + stack.size
    }
}