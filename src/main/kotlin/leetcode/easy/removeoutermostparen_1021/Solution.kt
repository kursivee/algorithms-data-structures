package leetcode.easy.removeoutermostparen_1021

// https://leetcode.com/problems/remove-outermost-parentheses/submissions/
class Solution {
    fun removeOuterParentheses(s: String): String {
        var count = 0
        var ans = ""
        s.forEach {
            if(it == '(') {
                if(count != 0) {
                    ans += it
                }
                count++
            } else {
                if(count != 1) {
                    ans += it
                }
                count--
            }
        }
        return ans
    }
}

fun main() {
    Solution().removeOuterParentheses("(()())(())").also { println(it == "()()()") }
    Solution().removeOuterParentheses("(()())(())(()(()))").also { println(it == "()()()()(())") }
    Solution().removeOuterParentheses("()()").also { println(it == "") }
}