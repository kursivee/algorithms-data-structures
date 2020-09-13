package leetcode.easy.cousinsinbintree_993

import leetcode.easy.mergetwobinarytrees_617.TreeNode
import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    class Solution {

        fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
            if(root == null) return false
            // node, parent val
            val queue = ArrayDeque<Pair<TreeNode, TreeNode?>>()
            queue.add(root to null)
            while(queue.isNotEmpty()) {
                var xParent: TreeNode? = null
                var yParent: TreeNode? = null
                val size = queue.size
                for(i in 0 until size) {
                    val item = queue.poll()
                    if(item.first.`val` == x) xParent = item.second
                    if(item.first.`val` == y) yParent = item.second
                    item.first.left?.let { queue.add(it to item.first) }
                    item.first.right?.let { queue.add(it to item.first) }
                }
                if(xParent == null && yParent == null) continue
                return when {
                    xParent == null && yParent != null -> false
                    xParent != null && yParent == null -> false
                    xParent!!.`val` != yParent!!.`val` -> true
                    else -> false
                }
            }
            return false
        }
    }

    // <depth, parent>
    private var xNode: Pair<Int, Int>? = null
    private var yNode: Pair<Int, Int>? = null

    fun isCousinsDfs(root: TreeNode?, x: Int, y: Int): Boolean {
        traverse(root, x, y, 0, null)
        if(xNode == null || yNode == null) return false
        return xNode!!.first == yNode!!.first && xNode!!.second != yNode!!.second
    }

    private fun traverse(node: TreeNode?, x: Int, y: Int, depth: Int, parent: TreeNode?) {
        if(node == null) return
        if(parent != null) {
            if(node.`val` == x) {
                xNode = depth to parent.`val`
                return
            }
            if(node.`val` == y) {
                yNode = depth to parent.`val`
                return
            }
        }
        traverse(node.left, x, y, depth + 1, node)
        traverse(node.right, x, y, depth + 1, node)
    }
}