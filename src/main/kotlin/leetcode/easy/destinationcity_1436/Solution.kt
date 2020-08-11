package leetcode.easy.destinationcity_1436

class Solution {
    fun destCity(paths: List<List<String>>): String {
        val list = mutableListOf<String>()
        paths.forEach { dests ->
            list.add(dests[1])
        }
        paths.forEach { dests ->
            list.remove(dests[0])
        }
        return list[0]
    }
}