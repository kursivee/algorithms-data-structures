package leetcode.medium.findrootnarytree_1506

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

data class Node(
    var `val`: Int,
    var children: List<Node?> = listOf()
)

/*
Tag: Tree, Tree traversal
Intuition:
Iterate through the list of nodes and traverse them.
We mark each traversed node as traversed.
The node we are looking at that has all nodes marked as traversed is the root node.
That's because we cannot mark the last node as traversed until we visit the root node itself.

Time Complexity: O(n)
Space Complexity: O(n)
 */
class Solution {
    private val list = mutableListOf<Int>()
    fun findRoot(tree: List<Node>): Node? {
        tree.forEach { node ->
            traverse(node)
            if(list.size == tree.size) return node
        }
        return null
    }

    private fun traverse(node: Node?) {
        if(node == null) return
        if(list.contains(node.`val`)) return
        list.add(node.`val`)
        node.children.forEach { child ->
            traverse(child)
        }
    }
}