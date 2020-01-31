package leetcode.easy.convertbinarytoint_1290
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/submissions/
class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        var s = ""
        var curr = head
        while(curr != null) {
            s += curr.`val`
            curr = curr.next
        }
        return binaryToBase(s)
    }

    private fun binaryToBase(s: String): Int {
        var ans = 0
        s.reversed().forEachIndexed { index, i ->
            if(i.toString().toInt() == 1) {
                ans += Math.pow(2.0, index.toDouble()).toInt()
            }
        }
        return ans
    }
}

fun main() {
    val listNode = ListNode(1).apply {
        next = ListNode(0).apply {
            next = ListNode(1)
        }
    }
    Solution().getDecimalValue(listNode).also { println(it) }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
