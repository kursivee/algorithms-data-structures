package leetcode.easy.deletennodesaftermnodeslinkedlist_1474

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
class Solution {
    fun deleteNodes(head: ListNode?, m: Int, n: Int): ListNode? {
        var currNode: ListNode? = head
        var foundNode: ListNode? = null
        while(currNode != null) {
            repeat(m - 1) {
                currNode = currNode?.next
            }
            foundNode = currNode
            repeat(n + 1) {
                currNode = currNode?.next
            }
            foundNode?.next = currNode
        }
        return head
    }
}