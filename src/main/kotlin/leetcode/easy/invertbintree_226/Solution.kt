package leetcode.easy.invertbintree_226

import leetcode.easy.mergetwobinarytrees_617.TreeNode
import leetcode.easy.mergetwobinarytrees_617.log

// https://leetcode.com/problems/invert-binary-tree/
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
    fun invertTree(root: TreeNode?): TreeNode? {
        if(root == null) return null
        return traverse(root, TreeNode(0))
    }

    private fun traverse(root: TreeNode, newRoot: TreeNode): TreeNode {
        newRoot.`val` = root.`val`
        root.left?.let {
            newRoot.right = traverse(it, TreeNode(0))
        }
        root.right?.let {
            newRoot.left = traverse(it, TreeNode(0))
        }
        return newRoot
    }
}

fun main() {
    Solution().invertTree(
        TreeNode(4).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(3)
            }
            right = TreeNode(7).apply {
                left = TreeNode(6)
                right = TreeNode(9)
            }
        }
    ).also {
        log(it!!)
    }
}