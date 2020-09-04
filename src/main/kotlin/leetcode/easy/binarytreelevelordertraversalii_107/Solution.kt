package leetcode.easy.binarytreelevelordertraversalii_107

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
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        if(root == null) return emptyList()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        val ans = mutableListOf<List<Int>>()
        while(queue.isNotEmpty()) {
            val count = queue.size
            val list = mutableListOf<Int>()
            repeat(count) {
                val node = queue.poll()
                list.add(node.`val`)
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            ans.add(0, list)
        }
        return ans
    }
}