package leetcode.easy.leafsimilartrees_872

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

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        if(root1 == null && root2 == null) return true
        if(root1 == null || root2 == null) return false
        return traverse(root1, mutableListOf()) == traverse(root2, mutableListOf())
    }

    private fun traverse(root: TreeNode, sequence: MutableList<Int>): List<Int> {
        if(root.left == null && root.right == null) {
            sequence.add(root.`val`)
        }
        root.left?.let {
            traverse(it, sequence)
        }
        root.right?.let {
            traverse(it, sequence)
        }
        return sequence
    }
}

fun main() {
    Solution().leafSimilar(
        TreeNode(3).apply {
            left = TreeNode(5)
            right = TreeNode(1)
        },
        TreeNode(3).apply {
            left = TreeNode(5)
            right = TreeNode(1)
        }
    ).also {
        println(it)
    }

    Solution().leafSimilar(
        TreeNode(3).apply {
            left = TreeNode(5)
            right = TreeNode(1)
        },
        TreeNode(3).apply {
            left = TreeNode(5)
            right = TreeNode(3)
        }
    ).also {
        println(it)
    }
}