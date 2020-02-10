package leetcode.easy.middlelinkedlist_876

import leetcode.easy.convertbinarytoint_1290.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
// https://leetcode.com/submissions/detail/301837460/
class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        if(head?.next == null) return head
        var node = head
        var count = 1
        while(node?.next != null) {
            count++
            node = node.next
        }
        count = ((count / 2.0) + 1.0).toInt()
        node = head
        for(i in 0 until count - 1) {
            node = node?.next
        }
        return node
    }
}

fun main() {
    val n1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    Solution().middleNode(n1).also { println(it?.`val`) }

    val n2  = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(6)
                    }
                }
            }
        }
    }
    Solution().middleNode(n2).also { println(it?.`val`) }

    val n3  = ListNode(1)
    Solution().middleNode(n3).also { println(it?.`val`) }
}