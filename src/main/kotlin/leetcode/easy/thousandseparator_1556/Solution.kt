package leetcode.easy.thousandseparator_1556

class Solution {
    fun thousandSeparator(n: Int): String {
        if(n == 0) return "0"
        var s = ""
        var num = n
        var count = 0
        while(num > 0) {
            if(count % 3 == 0 && count != 0) {
                s = ".$s"
            }
            s = "${num % 10}$s"
            num = num / 10
            count++
        }
        return s
    }
}