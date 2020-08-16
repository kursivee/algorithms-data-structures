package leetcode.medium.clonenarytree_1490

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

class Solution {
    fun cloneTree(root: Node?): Node? {
        if(root == null) return null
        return clone(root)
    }

    private fun clone(real: Node?): Node? {
        if(real == null) return null
        val clone = Node(real.`val`)
        val children = mutableListOf<Node?>()
        real.children.forEach {
            children.add(clone(it))
        }
        clone.children = children
        return clone
    }
}