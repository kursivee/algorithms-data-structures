package leetcode.medium.deletenodesreturnforest_1110

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
    private val ans = mutableListOf<TreeNode?>()
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        if(root == null) return emptyList()
        postorder(root, to_delete.toList())
        if(!to_delete.toList().contains(root.`val`)) ans.add(root)
        return ans
    }

    private fun postorder(node: TreeNode?, deleteList: List<Int>) {
        if(node == null) return
        postorder(node.left, deleteList)
        if(deleteList.contains(node.left?.`val` ?: 0)) {
            node.left = null
        }
        postorder(node.right, deleteList)
        if(deleteList.contains(node.right?.`val` ?: 0)) {
            node.right = null
        }
        if(deleteList.contains(node.`val`)) {
            if(node.left != null) ans.add(node.left)
            if(node.right != null) ans.add(node.right)
        }

    }
}