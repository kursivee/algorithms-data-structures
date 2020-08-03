package leetcode.medium.bintreeinorder_94

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
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if(root == null) return emptyList()
        traverse(root)
        return list
    }

    private fun traverse(root: TreeNode?) {
        if(root == null) return
        traverse(root.left)
        list.add(root.`val`)
        traverse(root.right)
    }
}

fun main() {
    Solution().inorderTraversal(TreeNode(1).apply {
        right = TreeNode(2).apply {
            left = TreeNode(3)
        }
    }).also {
        println(it.joinToString(", "))
    }
}