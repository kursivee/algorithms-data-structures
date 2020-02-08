package leetcode.easy.univaluedbintree_965

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
// https://leetcode.com/problems/univalued-binary-tree/submissions/
class Solution {
    private var target: Int? = null
    fun isUnivalTree(root: TreeNode?): Boolean {
        if(root == null) return true
        target = root.`val`
        return traverse(root)
    }

    private fun traverse(root: TreeNode?): Boolean {
        if(root == null) return true
        if(root.`val` != target) return false
        return traverse(root.left) && traverse(root.right)
    }
}

fun main() {
    Solution().isUnivalTree(TreeNode(1).apply {
        left = TreeNode(1).apply {
            right = TreeNode(3)
        }
    }).also { println(it) }
}