package leetcode.easy.deletenodelinklist_237

import leetcode.easy.reverselinkedlist_206.ListNode

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// https://leetcode.com/problems/delete-node-in-a-linked-list/
class Solution {

    // This was a super confusing question
    fun deleteNode(node: ListNode): ListNode {
        node.`val` = node.next?.`val`
        node.next = node.next?.next
        return node
    }
}

fun main() {
    Solution().deleteNode(ListNode(3).apply {
        next = ListNode(2)
    }).also {
        var curr: ListNode? = it
        while(curr != null) {
            println(curr.`val`)
            curr = curr.next
        }
    }
}