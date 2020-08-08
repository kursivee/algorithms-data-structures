package leetcode.medium.mininserttobalanceparen_1541

import java.util.*

class Solution {
    /*
    add ( when ) and stack is empty
    add ) when ( and previous is )
    */
    fun minInsertions(s: String): Int {
        val stack = ArrayDeque<Char>()
        var count = 0
        s.forEach { char ->
            if(stack.isEmpty()) {
                if(char == ')') {
                    stack.push('(')
                    stack.push(char)
                    count++
                } else {
                    stack.push(char)
                }
            } else if(stack.peek() == ')' && char == ')') {
                stack.pop()
                stack.pop()
            } else if(stack.peek() == ')' && char == '(') {
                stack.pop()
                stack.pop()
                stack.push(char)
                count++
            } else
                stack.push(char)
        }
        var total = 0
        if(!stack.isEmpty()) {
            stack.forEach { char ->
                if(char == '(') total += 2
                else total--
            }
        }
        return count + Math.abs(total)
    }
}