package leetcode.easy.removelinkedlistele_203

import leetcode.easy.reverselinkedlist_206.ListNode

class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if(head == null) return null
        var ans = head
        if(ans.`val` == `val`) {
            ans = removeElements(ans.next, `val`)
        } else {
            ans.next = removeElements(ans.next, `val`)
        }
        return ans
    }
}

fun main() {
    Solution().removeElements(ListNode(1).apply {
        next = ListNode(1)
    }, 1).also {
        println(it)
    }
}

