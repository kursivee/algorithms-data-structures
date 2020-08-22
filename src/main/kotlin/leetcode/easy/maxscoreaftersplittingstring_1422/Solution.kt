package leetcode.easy.maxscoreaftersplittingstring_1422

class Solution {
    /*
    Tag: Prefix Sum
    Intuition:


    1,1,1,1,2
    1,1,2,3,4

    for l
    prefix sum from 1 .. length - 1
    for r
    prefix sum from 2 .. length

    Unoptimized solution
    */
    fun maxScore(s: String): Int {
        val zeros = IntArray(s.length - 1)
        val ones = IntArray(s.length - 1)

        zeros[0] = if(s[0] == '0') 1 else 0
        ones[0] = if(s[s.length - 1] == '0') 0 else 1

        for(i in 1 until zeros.size) {
            val n = if(s[i] == '0') 1 else 0
            zeros[i] = zeros[i - 1] + n
        }

        for(i in 1 until ones.size) {
            val n = if(s[s.length - 1 - i] == '1') 1 else 0
            ones[i] = ones[i - 1] + n
        }

        var max = 0
        for(i in zeros.indices) {
            max = Math.max(max, zeros[i] + ones[zeros.size - 1 - i])
        }
        return max
    }
}