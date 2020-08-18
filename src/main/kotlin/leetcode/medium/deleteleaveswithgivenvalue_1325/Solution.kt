package leetcode.medium.deleteleaveswithgivenvalue_1325

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
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        return if(postorder(root, target)) null else root
    }

    // returns if target
    fun postorder(node: TreeNode?, k: Int): Boolean {
        if(node == null) return true
        val l = postorder(node.left, k)
        val r = postorder(node.right, k)
        if(l) {
            node.left = null
        }
        if(r) {
            node.right = null
        }
        if(node.`val` == k && l && r) {
            return true
        }
        return false
    }
}