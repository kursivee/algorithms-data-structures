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
        var l = l1
        var r = l2
        var carry = 0
        while(l != null || r != null) {
            val lVal = l?.`val` ?: 0
            val rVal = r?.`val` ?: 0
            var sum = lVal + rVal + carry
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
            l = l?.next
            r = r?.next
        }
        if(carry == 1) {
            curr?.next = ListNode(1)
        }
        return ans
    }


}

fun main() {
    Solution().addTwoNumbers(ListNode(9).apply {
        next = ListNode(8)
    }, ListNode(1)).also {
        var node = it
        while(node != null) {
            print(node.`val`)
            node = node.next
        }
    }
}