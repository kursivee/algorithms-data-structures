package leetcode.easy.buildarraywithstack_1441

class Solution {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val ans = mutableListOf<String>()
        var count = target.size
        for(i in 1 .. n) {
            ans.add("Push")
            if(target.contains(i)) {
                count--
            } else {
                ans.add("Pop")
            }
            if(count == 0) break
        }
        return ans
    }
}