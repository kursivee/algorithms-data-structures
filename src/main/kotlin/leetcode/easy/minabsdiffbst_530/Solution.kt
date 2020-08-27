package leetcode.easy.minabsdiffbst_530

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
    var min = Int.MAX_VALUE
    fun getMinimumDifference(root: TreeNode?): Int {
        if(root == null) return 0
        if(root.left == null && root.right == null) return root.`val`
        preorder(root, mutableListOf())
        return min
    }

    private fun preorder(node: TreeNode?, prev: MutableList<Int>) {
        if(node == null) return
        prev.forEach { n ->
            min = minOf(Math.abs(n - node.`val`), min)
        }
        prev.add(node.`val`)
        preorder(node.left, prev)
        preorder(node.right, prev)
    }
}