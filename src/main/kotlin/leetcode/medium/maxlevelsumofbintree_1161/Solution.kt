package leetcode.medium.maxlevelsumofbintree_1161

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
    fun maxLevelSum(root: TreeNode?): Int {
        if(root == null) return 0
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var max = root.`val`
        var maxLevel = 1
        var level = 1
        while(!queue.isEmpty()) {
            val count = queue.size
            var sum = 0
            for(i in 0 until count) {
                val node = queue.poll()
                sum += node.`val`
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            if(sum > max) {
                max = sum
                maxLevel = level
            }
            level++
        }
        return maxLevel
    }
}