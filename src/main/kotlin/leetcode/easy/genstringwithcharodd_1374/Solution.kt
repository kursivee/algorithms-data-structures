package leetcode.easy.genstringwithcharodd_1374

class Solution {
    fun generateTheString(n: Int): String {
        var s = ""
        repeat(n - 1) {
            s += "a"
        }
        s += if(n % 2 == 0) {
            "b"
        } else {
            "a"
        }
        return s
    }
}