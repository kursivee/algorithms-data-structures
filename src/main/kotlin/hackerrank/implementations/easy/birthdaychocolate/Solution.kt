package hackerrank.implementations.easy.birthdaychocolate

class Solution {
    fun birthday(s: Array<Int>, d: Int, m: Int): Int {
        if(s.size == 1) {
            if(s[0] == d && m == 1) return 1
            return 0
        }
        var count = 0
        for(i in 0 .. s.size - m) {
            var sum = 0
            for(j in i until i+m) {
                sum += s[j]
            }
            if(sum == d) count++
        }
        return count
    }
}

fun main() {
    Solution().birthday(arrayOf(
        2,5,1,3,4,4,3,5,1,1,2,1,4,1,3,3,4,2,1
    ), 18, 7).also { println(it) }

//    Solution().birthday(arrayOf(
//        1,2,1,3,2
//    ), 3, 2).also { println(it) }
//
//    Solution().birthday(arrayOf(
//        4
//    ), 4, 1).also { println(it) }
}