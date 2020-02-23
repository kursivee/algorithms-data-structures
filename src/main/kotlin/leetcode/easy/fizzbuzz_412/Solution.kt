package leetcode.easy.fizzbuzz_412

// https://leetcode.com/problems/fizz-buzz/
class Solution {
    fun fizzBuzz(n: Int): List<String> {
        val list = mutableListOf<String>()
        for(i in 1..n) {
            list.add(when {
                i % 15 == 0 -> "FizzBuzz"
                i % 5 == 0 -> "Buzz"
                i % 3 ==0 -> "Fizz"
                else -> "$i"
            })
        }
        return list
    }
}

fun main() {
    Solution().fizzBuzz(30).also {
        println(it)
    }
}