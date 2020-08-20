package leetcode.medium.reorderlist_143

import leetcode.easy.convertbinarytoint_1290.ListNode
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
    fun reorderList(head: ListNode?): Unit {
        if(head == null) return
        val queue = ArrayDeque<ListNode>()
        var curr = head
        while(curr != null) {
            queue.offer(curr)
            curr = curr.next
        }
        var shouldPollFirst = true
        while(queue.isNotEmpty()) {
            val node = if(shouldPollFirst) {
                queue.pollFirst()
            } else queue.pollLast()
            if(curr == null) {
                curr = node
            } else {
                curr.next = node
                node.next = null
                curr = node
            }
            shouldPollFirst = !shouldPollFirst
        }
    }
}