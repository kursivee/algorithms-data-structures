package leetcode.easy.pascalstriangle_118

class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        if(numRows == 0) return emptyList()
        val ans = mutableListOf<List<Int>>()
        ans.add(listOf(1))
        if(numRows == 1) return ans
        ans.add(listOf(1,1))
        for(i in 2 until numRows) {
            val list = mutableListOf(1)
            val prev = ans.last()
            for(j in 0 until prev.size - 1) {
                list.add(prev[j] + prev[j + 1])
            }
            list.add(1)
            ans.add(list)
        }
        return ans
    }
}