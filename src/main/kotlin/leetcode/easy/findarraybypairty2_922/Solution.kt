package leetcode.easy.findarraybypairty2_922

// https://leetcode.com/problems/sort-array-by-parity-ii/
class Solution {
    /*
        if even && wrong then find odd && wrong && switch
        if odd && wrong then find even && wrong && switch
     */
    fun sortArrayByParityII(arr: IntArray): IntArray {
        for(i in 0..arr.size - 2) {
            if(arr[i] % 2 != i % 2) {
                for(j in i until arr.size) {
                    if(arr[i] % 2 != arr[j] % 2 && (arr[j] % 2 != j % 2)) {
                        val temp = arr[i]
                        arr[i] = arr[j]
                        arr[j] = temp
                        break
                    }
                }
            }
        }
        return arr
    }
}

fun main() {
    Solution().sortArrayByParityII(intArrayOf(
        4,2,5,7
    )).also { println(it.joinToString(", ")) }
}