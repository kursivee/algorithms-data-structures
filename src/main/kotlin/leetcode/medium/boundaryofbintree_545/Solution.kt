package leetcode.medium.boundaryofbintree_545

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
    private val ans = mutableListOf<Int>()
    fun boundaryOfBinaryTree(root: TreeNode?): List<Int> {
        if(root == null) return emptyList()
        // root
        // left
        // right
        ans.add(root.`val`)
        boundaryLeft(root.left)
        leaves(root.left)
        leaves(root.right)
        boundaryRight(root.right)
        return ans
    }

    private fun boundaryLeft(root: TreeNode?) {
        if(root == null) return
        if(root.left == null && root.right == null) return
        ans.add(root.`val`)
        if(root.left == null) {
            boundaryLeft(root.right)
        } else {
            boundaryLeft(root.left)
        }

    }

    private fun boundaryRight(root: TreeNode?) {
        if(root == null) return
        if(root.left == null && root.right == null) return
        if(root.right == null) {
            boundaryRight(root.left)
        } else {
            boundaryRight(root.right)
        }
        ans.add(root.`val`)
    }

    private fun leaves(root: TreeNode?) {
        if(root == null) return
        if(root.left == null && root.right == null) {
            ans.add(root.`val`)
        }
        leaves(root.left)
        leaves(root.right)
    }
}

fun main() {
    Solution().boundaryOfBinaryTree(TreeNode(1).apply {
        right = TreeNode(2).apply {
            left = TreeNode(3)
            right = TreeNode(4)
        }
    }).also {
        println(it.joinToString(", "))
    }
}