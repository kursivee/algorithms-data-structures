package leetcode.easy.selfdividingnumbers_728

// https://leetcode.com/problems/self-dividing-numbers/
class Solution {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val list = mutableListOf<Int>()
        for(i in left..right) {
            if(i < 10) {
                list.add(i)
            } else {
                i.toString().run {
                    if(!contains("0")) {
                        find { i % it.toString().toInt() != 0 } ?: run {
                            list.add(i)
                        }
                    }
                }
            }
        }
        return list
    }
}

fun main() {
    Solution().selfDividingNumbers(1,22).also { println(it) }
}