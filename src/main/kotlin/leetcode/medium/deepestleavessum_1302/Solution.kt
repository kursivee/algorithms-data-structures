package leetcode.medium.deepestleavessum_1302

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
// https://leetcode.com/problems/deepest-leaves-sum/
class Solution {

    val map = mutableMapOf<Int, Int>()

    fun deepestLeavesSum(root: TreeNode?): Int {
        if(root == null) return 0
        recursive(root, 0)
        return map[map.keys.max()]!!
    }

    fun recursive(root: TreeNode, depth: Int) {
        if(root.left == null && root.right == null) {
            map[depth] = (map[depth] ?: 0) + root.`val`
        }
        root.left?.let {
            recursive(it, depth + 1)
        }
        root.right?.let {
            recursive(it, depth + 1)
        }
    }
}

fun main() {
    Solution().deepestLeavesSum(
        TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4).apply {
                    left = TreeNode((7))
                }
                right = TreeNode(5)
            }
            right = TreeNode(3).apply {
                right = TreeNode(6).apply {
                    right = TreeNode(8)
                }
            }
        }
    ).also {
        println(it)
    }
}