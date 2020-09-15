package leetcode.easy.lemonadechange_860

class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        val change = IntArray(21)
        bills.forEach { bill ->
            when(bill) {
                5 -> change[5]++
                10 -> {
                    if(change[5] == 0) return false
                    change[5]--
                    change[10]++
                }
                else -> {
                    when {
                        change[10] == 0 -> {
                            if(change[5] < 3) return false
                            change[5] -= 3
                        }
                        change[5] == 0 -> return false
                        else -> {
                            change[5]--
                            change[10]--
                        }
                    }
                }
            }
        }
        return true
    }
}