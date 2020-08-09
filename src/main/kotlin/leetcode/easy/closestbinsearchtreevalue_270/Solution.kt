package leetcode.easy.closestbinsearchtreevalue_270

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

    fun closestValue(root: TreeNode?, target: Double): Int {
        return preorder(root, target, -1 to Double.MAX_VALUE).first
    }

    private fun preorder(root: TreeNode?, target: Double, pair: Pair<Int, Double>): Pair<Int, Double> {
        if(root == null) return -1 to Double.MAX_VALUE
        val diff = Math.abs(root.`val` - target)
        var ans = pair
        if(diff < pair.second) {
            ans = root.`val` to diff
        }
        val l = preorder(root.left, target, ans)
        if(ans.second > l.second) ans = l
        val r = preorder(root.right, target, ans)
        if(ans.second > r.second) ans = r
        return ans
    }
}