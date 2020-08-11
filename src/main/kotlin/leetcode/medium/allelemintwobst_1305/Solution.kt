package leetcode.medium.allelemintwobst_1305

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
    private val list = mutableListOf<Int>()

    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        inorder(root1)
        inorder(root2)
        return list.sorted()
    }

    private fun inorder(node: TreeNode?) {
        if(node == null) return
        inorder(node.left)
        list.add(node.`val`)
        inorder(node.right)
    }
}