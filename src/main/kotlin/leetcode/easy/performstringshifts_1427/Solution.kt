package leetcode.easy.performstringshifts_1427

class Solution {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        var newS = s
        shift.forEach { sh ->
            newS = if(sh[0] == 1) {
                newS.right(sh[1])
            } else newS.left(sh[1])
        }
        return newS
    }

    private fun String.right(k: Int): String {
        return left(length - k)
    }

    private fun String.left(k: Int): String {
        val newK = k % length
        return "${substring(newK)}${substring(0, newK)}"
    }
}