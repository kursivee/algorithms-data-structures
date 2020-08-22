package leetcode.easy.twosumivbst_653

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
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        return preorder(root, k, mutableSetOf())
    }

    private fun preorder(node: TreeNode?, k: Int, set: MutableSet<Int>): Boolean {
        if(node == null) return false
        val n = k - node.`val`
        if(set.contains(n)) return true
        set.add(node.`val`)
        if(preorder(node.left, k, set)) return true
        if(preorder(node.right, k, set)) return true
        return false
    }
}