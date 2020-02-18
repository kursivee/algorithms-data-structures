package leetcode.easy.maxdepthbintree_104

import leetcode.easy.mergetwobinarytrees_617.TreeNode

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
// https://leetcode.com/problems/maximum-depth-of-binary-tree/
class Solution {
    private var max = 0

    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0
        maxDepth(root, 0)
        return max
    }

    private fun maxDepth(root: TreeNode, count: Int) {
        val c = count + 1
        if(root.left == null && root.right == null) {
            max = Math.max(max, c)
        }
        root.left?.let {
            maxDepth(it, c)
        }
        root.right?.let {
            maxDepth(it, c)
        }
    }
}

fun main() {
    Solution().maxDepth(
        TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
    ).also {
        println(it == 3)
    }

    Solution().maxDepth(
        TreeNode(3)
    ).also {
        println(it == 1)
    }
}