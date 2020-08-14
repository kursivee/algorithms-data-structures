package leetcode.medium.minnumstepstomaketwoanagram_1347

class Solution {
    fun minSteps(s: String, t: String): Int {
        var arrS = IntArray(26)
        var arrT = IntArray(26)
        s.forEach { char ->
            arrS[char - 'a']++
        }
        t.forEach { char ->
            arrT[char - 'a']++
        }
        var sum = 0
        for(i in arrS.indices) {
            val diff = Math.abs(arrS[i] - arrT[i])
            sum += diff
        }
        return sum / 2
    }
}