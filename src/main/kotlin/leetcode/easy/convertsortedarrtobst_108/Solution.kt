package leetcode.easy.convertsortedarrtobst_108

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
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if(nums.isEmpty()) return null
        return build(nums, 0, nums.size - 1)
    }

    private fun build(nums: IntArray, l: Int, r: Int): TreeNode? {
        if(l > r) return null
        val mid = l + (r - l) / 2
        val node = TreeNode(nums[mid])
        node.left = build(nums, l, mid - 1)
        node.right = build(nums, mid + 1, r)
        return node
    }
}