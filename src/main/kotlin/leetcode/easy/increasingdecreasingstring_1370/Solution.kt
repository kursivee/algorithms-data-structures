package leetcode.easy.increasingdecreasingstring_1370

class Solution {
    fun sortString(s: String): String {
        val c = charArrayOf(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q','r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        )

        val charArr = IntArray(26)
        s.forEach { char ->
            charArr[char - 'a']++
        }
        var count = 0
        var output = ""
        while(count < s.length) {
            if(count % 2 == 0) {
                for(i in 0 until 26) {
                    if(charArr[i] > 0) {
                        charArr[i]--
                        output += "${c[i]}"
                    }
                }
            } else {
                for(i in 25 downTo 0) {
                    if(charArr[i] > 0) {
                        charArr[i]--
                        output += "${c[i]}"
                    }
                }
            }
            count++
        }
        return output
    }
}