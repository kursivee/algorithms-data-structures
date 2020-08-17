package leetcode.medium.outputcontestmatches_544

import java.util.*

class Solution {
    /*
    Tag: Linked List
    Intuition:
    We are going to match strongest vs. weakest at every round
    Equivalent to combining the head and tail of a list at every iteration
    head 1,2,3,4,5,6,7,8 tail
    head (1,8),(2,7),(3,6)(4,5) tail
    head (1,8),(4,5) (2,7),(3,6) tail

    Note: Use ArrayDeque over ArrayList since removing tail from ArrayList takes O(n)
    Time Complexity: O(n log n)
    Space Complexity: O(n log n)
    */
    fun findContestMatch(n: Int): String {
        var ans = ArrayDeque<String>()
        for(i in 1 .. n) ans.offer("$i")
        while(ans.size > 1) {
            val tmp = ArrayDeque<String>()
            while(ans.isNotEmpty()) {
                val s = "(${ans.pollFirst()},${ans.pollLast()})"
                tmp.offer(s)
            }
            ans = tmp
        }
        return ans.poll()
    }
}