package leetcode.easy.sumofleftleaves_404

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
    private var sum = 0
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        preorder(root, false)
        return sum
    }

    private fun preorder(node: TreeNode?, isLeft: Boolean) {
        if(node == null) return
        if(node.left == null && node.right == null && isLeft) {
            sum += node.`val`
        }
        preorder(node.left, true)
        preorder(node.right, false)
    }
}