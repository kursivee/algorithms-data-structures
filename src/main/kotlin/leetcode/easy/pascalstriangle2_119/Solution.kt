package leetcode.easy.pascalstriangle2_119

class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        var list = listOf(1)
        if(rowIndex == 0) return list
        repeat(rowIndex) {
            list = buildRow(list)
        }
        return list
    }

    private fun buildRow(prevList: List<Int>): List<Int> {
        if(prevList.size == 1) return listOf(1,1)
        val list = mutableListOf<Int>()
        list.add(1)
        for(i in 0 until prevList.size - 1) {
            list.add(prevList[i] + prevList[i + 1])
        }
        list.add(1)
        return list
    }
}