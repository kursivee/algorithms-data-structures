package leetcode.easy.reverselinkedlist_206

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
// https://leetcode.com/problems/reverse-linked-list/
class Solution {
    fun reverseList2(head: ListNode?): ListNode? {
        if(head == null) return null
        val stack = ArrayDeque<Int>()
        var curr = head
        while(curr != null) {
            stack.push(curr.`val`)
            curr = curr.next
        }
        val node = ListNode(stack.pop())
        curr = node
        while(stack.isNotEmpty()) {
            curr!!.next = ListNode(stack.pop())
            curr = curr.next
        }
        return node
    }

    fun reverseList(head: ListNode?): ListNode? {
        if(head?.next == null) return head
        val node = reverseList(head.next)
        head.next!!.next = head
        head.next = null
        return node
    }

    private var node: ListNode? = null
    private fun reverse(head: ListNode, n: ListNode): ListNode {
        var curr = n
        if(head.next != null) {
            curr = reverse(head.next!!, n)
            curr.next = ListNode(head.`val`)
        } else {
            curr.`val` = head.`val`
            node = curr
        }
        return curr.next ?: curr
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    Solution().reverseList(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }).also {
        var node = it
        while(node != null) {
            print("${node.`val`} ")
            node = node.next
        }
    }
}