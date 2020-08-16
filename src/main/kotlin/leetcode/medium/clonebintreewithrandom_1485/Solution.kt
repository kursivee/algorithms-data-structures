package leetcode.medium.clonebintreewithrandom_1485

/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var random: Node? = null
 * }
 */
class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var random: Node? = null
}

class NodeCopy(var `val`: Int) {
    var left: NodeCopy? = null
    var right: NodeCopy? = null
    var random: NodeCopy? = null
}

class Solution {
    // Using a cache to handle cases where random pointer points to an already
    // existing NodeCopy. We want to make sure we aren't recreating a NodeCopy.
    private val cache = mutableMapOf<Node, NodeCopy>()
    fun copyRandomBinaryTree(root: Node?): NodeCopy? {
        return preorder(root)
    }

    private fun preorder(original: Node?): NodeCopy? {
        if(original == null) return null
        val c = cache.getOrDefault(original, NodeCopy(original.`val`))
        if(!cache.contains(original)) {
            cache[original] = c
        } else return c
        c.left = preorder(original.left)
        c.right = preorder(original.right)
        c.random = preorder(original.random)
        return c
    }
}