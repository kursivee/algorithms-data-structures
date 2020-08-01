package leetcode.easy.sametree_100

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
    /*
    the same if they traverse the same
    preorder traversal: root, left, right
    if they differ then they don't match
    */

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if(p == null && q == null) return true
        if(p?.`val` != q?.`val`) return false
        val left = isSameTree(p?.left, q?.left) != false
        val right = isSameTree(p?.right, q?.right) != false
        return left && right
    }
}

fun main() {
    val node1 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }
    val node2 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(4)
    }
    Solution().isSameTree(node1, node1).also {
        println(it)
    }
    Solution().isSameTree(node1, node2).also {
        println(it)
    }
}

