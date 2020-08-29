package leetcode.medium.implrand10usingrand7_470

/**
 * The rand7() API is already defined in the parent class SolBase.
 * fun rand7(): Int {}
 * @return a random integer in the range 1 to 7
 */
open class SolBase {
    fun rand7(): Int {
        return (Math.random() * 6).toInt() + 1
    }
}

class Solution : SolBase() {
    fun rand10(): Int {
        var rand40 = Int.MAX_VALUE
        while(rand40 >= 40) {
            rand40 = (rand7() - 1) * 7 + rand7() - 1
        }
        return rand40 % 10 + 1
    }
}