package leetcode.easy.replacewithgreatest_1299

// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        val ans = IntArray(arr.size)
        var i = 0
        while(i < arr.size) {
            var replace = -1
            var replaceIndex = -1
            for(j in i+1 until arr.size) {
                if(arr[j] > replace) {
                    replace = arr[j]
                    replaceIndex = j
                }
            }
            for(j in i until replaceIndex) {
                ans[j] = replace
            }
            if(replaceIndex != -1)
                i = replaceIndex
            else i++
        }
        ans[ans.size - 1] = -1
        return ans
    }
}

fun main() {
    Solution().replaceElements(intArrayOf(
        17,18,5,4,6,1
    )).also { println(it.joinToString(", ")) }
}