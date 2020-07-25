package leetcode.medium.addtwonumbers_2

import leetcode.easy.reverselinkedlist_206.ListNode
import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var ans: ListNode? = null
        var curr: ListNode? = null
        val s1 = ArrayDeque<Int>()
        val s2 = ArrayDeque<Int>()
        var l = l1
        var r = l2
        while(l != null) {
            s1.push(l.`val`)
            l = l.next
        }
        while(r != null) {
            s2.push(r.`val`)
            r = r.next
        }
        var carry = 0
        while(s1.size > 0 || s2.size > 0) {
            val v1 = s1.pollLast() ?: 0
            val v2 = s2.pollLast() ?: 0
            var sum = v1 + v2 + carry
            if(sum >= 10) {
                carry = 1
                sum -= 10
            } else {
                carry = 0
            }
            val node = ListNode(sum)
            if(ans == null) {
                ans = node
                curr = node
            } else {
                curr?.next = node
                curr = node
            }
        }
        if(carry == 1) {
            val node = ListNode(1)
            curr?.next = node
        }
        return ans
    }


}

fun main() {
    Solution().addTwoNumbers(ListNode(9).apply {
        next = ListNode(8)
    }, ListNode(0)).also {
        var node = it
        while(node != null) {
            print(node.`val`)
            node = node.next
        }
    }
}