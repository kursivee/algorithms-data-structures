package leetcode.medium.bintreepruning_814

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
    fun pruneTree(root: TreeNode?): TreeNode? {
        val bool = inorder(root)
        if(!bool) return null
        return root
    }

    fun inorder(node: TreeNode?): Boolean {
        if(node == null) return false
        var bool = node.`val` == 1
        val left = inorder(node.left)
        if(!left) {
            node.left = null
        }
        val right = inorder(node.right)
        if(!right) {
            node.right = null
        }
        return bool || left || right
    }
}