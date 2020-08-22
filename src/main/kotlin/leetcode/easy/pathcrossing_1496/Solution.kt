package leetcode.easy.pathcrossing_1496

class Solution {
    fun isPathCrossing(path: String): Boolean {
        val visited = mutableListOf<Pair<Int, Int>>()
        var i = 0
        var j = 0
        visited.add(i to j)
        for(p in path) {
            when(p) {
                'N' -> j++
                'S' -> j--
                'E' -> i++
                'W' -> i--
            }
            if(visited.contains(i to j)) return true
            visited.add(i to j)
        }
        return false
    }
}