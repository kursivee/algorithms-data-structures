package leetcode.easy.sumofroottoleafbin_1022

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
// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/submissions/
class Solution {
    fun sumRootToLeaf(root: TreeNode?): Int {
        if(root == null) return 0
        return traverse(root, "")
    }

    private fun traverse(root: TreeNode, s: String): Int {
        var sum = 0
        val s1 = s + root.`val`
        if(root.left == null && root.right == null) {
            sum += Integer.parseInt(s1, 2)
        }
        root.left?.let {
            sum += traverse(it, s1)
        }
        root.right?.let {
            sum += traverse(it, s1)
        }
        return sum
    }
}

fun main() {
    Solution().sumRootToLeaf(
        TreeNode(1).apply {
            left = TreeNode(0).apply {
                left = TreeNode(0)
                right = TreeNode(1)
            }
            right = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(1)
            }
        }
    ).also {
        println(it)
    }
}