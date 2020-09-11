package leetcode.medium.symmetrictree_101

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
    fun isSymmetric(root: TreeNode?): Boolean {
        if(root == null) return true
        if(root.left == null && root.right == null) return true
        return preorder(root.left, root.right)
    }

    private fun preorder(node1: TreeNode?, node2: TreeNode?): Boolean {
        if(node1 == null && node2 == null) return true
        if(node1 == null) return false
        if(node2 == null) return false
        val root = node1.`val` == node2.`val`
        val left = preorder(node1.left, node2.right)
        val right = preorder(node1.right, node2.left)
        if(!left || !right || !root) return false
        return true
    }
}