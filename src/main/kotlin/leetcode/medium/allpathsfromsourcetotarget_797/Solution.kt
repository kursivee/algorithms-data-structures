package leetcode.medium.allpathsfromsourcetotarget_797

class Solution {

    val res = mutableListOf<List<Int>>()

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        traverse(graph, 0, mutableListOf())
        return res
    }

    fun traverse(graph: Array<IntArray>, node: Int, ans: MutableList<Int>) {
        ans.add(node)
        if(node == graph.size - 1) {
            res.add(ans)
        } else {
            for(element in graph[node]) {
                traverse(graph, element, ans.toMutableList())
            }
        }
    }
}

fun main() {
    Solution().allPathsSourceTarget(arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3),
        intArrayOf(3),
        intArrayOf()
    )).also {
        it.forEach { list ->
            println(list.joinToString(", "))
        }
    }
}