package leetcode.medium.countgoodnodesinbintree_1448

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
    private var count = 0
    fun goodNodes(root: TreeNode?): Int {
        if(root == null) return 0
        dfs(root, Int.MIN_VALUE)
        return count
    }

    private fun dfs(node: TreeNode?, max: Int) {
        if(node == null) return
        var newMax = max
        if(max <= node.`val`) {
            count++
            newMax = node.`val`
        }
        dfs(node.left, newMax)
        dfs(node.right, newMax)
    }
}