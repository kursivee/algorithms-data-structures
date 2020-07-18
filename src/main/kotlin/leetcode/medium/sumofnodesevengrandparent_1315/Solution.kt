package leetcode.medium.sumofnodesevengrandparent_1315

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
class Solution {
    fun sumEvenGrandparent(root: TreeNode?): Int {
        return traverse(root, -1, -1)
    }

    fun traverse(root: TreeNode?, grandParent: Int, parent: Int): Int {
        if(root == null) return 0
        var newParent = if(parent == -1) root?.`val` else 0
        val leftSum = traverse(root?.left, parent, root?.`val`)
        val rightSum = traverse(root?.right, parent, root?.`val`)
        return leftSum + rightSum + if(grandParent % 2 == 0) root.`val` else 0
    }
}

fun main() {
    Solution().sumEvenGrandparent(
        TreeNode(6).apply {
            left = TreeNode(7).apply {
                left = TreeNode(2)
                right = TreeNode(7)
            }
            right = TreeNode(8).apply {
                left = TreeNode(1)
                right = TreeNode(3)
            }
        }
    ).also {
        println(it)
    }
}