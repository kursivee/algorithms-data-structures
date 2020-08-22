package leetcode.medium.minnumofvertstoreachallnodes_1557

class Solution {
    /*
    Tag: Graph
    Intuition:

    Since the graph is directed and acyclic we can assume that all source verticies will
    travel to all non-source verticies.

    Find the source verticies.
    */
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val indegree = mutableSetOf<Int>()
        edges.forEach { edge ->
            indegree.add(edge[1])
        }

        val list = mutableSetOf<Int>()
        edges.forEach { edge ->
            if(!indegree.contains(edge[0])) list.add(edge[0])
        }
        return list.toList()
    }

}