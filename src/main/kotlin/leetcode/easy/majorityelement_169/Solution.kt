package leetcode.easy.majorityelement_169

class Solution {
    /*
    Tag: Boyer-Moore
    Intuition:
    We know that the majority element will always have the most elements in the list
    We can track the current element we see the most in a prefix.
    Prefix end is when the running count reaches 0
    e.g.
    [1,1,2,2,3,1,1]

    At 1, count == 1, candidate == 1
    At 1, count == 2, candidate == 1
    At 2, count == 1, candidate == 1
    At 2, count == 0 , candidate == 1
    At 3, count == 1, candidate == 3 // reset since count was 0
    At 1, count == 0, candidate == 3
    At 1, count == 1, candidate == 1 // reset since count was 0

    The final candidate is 1

    This algorithm is known as the Boyer-Moore Voting algorithm

    Time Complexity: O(n)
    Space Complexity: O(1)

    */
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var candidate = 0
        for(n in nums) {
            if(count == 0) candidate = n
            if(candidate == n) count++
            else count--
        }
        return candidate
    }

    fun majorityElementMap(nums: IntArray): Int {
        val freq = mutableMapOf<Int, Int>()
        nums.forEach { n ->
            val count = freq.getOrDefault(n, 0)
            freq[n] = count + 1
        }
        return freq.maxBy { it.value }!!.key
    }
}