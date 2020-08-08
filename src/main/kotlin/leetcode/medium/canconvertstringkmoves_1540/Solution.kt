package leetcode.medium.canconvertstringkmoves_1540

class Solution {
    fun canConvertString(s: String, t: String, k: Int): Boolean {
        if(s.length != t.length) return false
        val arr = IntArray(s.length)
        for(i in s.indices) {
            val first = s[i] - 'a'
            val second = t[i] - 'a'
            var x = second - first
            if(x < 0) {
                x = second + 26 - first
            }
            if(x == 26) x = 0
            arr[i] = x
        }
        val freq = mutableMapOf<Int, Int>()
        arr.forEach {
            if(it != 0)
                freq[it] = freq[it]?.plus(1) ?: 1
        }

        val thresh = k / 26
        val maxShift = k % 26
        freq.entries.forEach {
            if((it.value <= thresh && it.key > maxShift) || (it.key <= maxShift && it.value <= thresh + 1)) {}
            else return false
        }
        if(arr.max()!! > k) return false
        return true
    }
}