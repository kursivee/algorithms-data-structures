package leetcode.medium.lowestcommonancestorbintree_236

import leetcode.easy.mergetwobinarytrees_617.TreeNode

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    var common = -1
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null) return null
        traverse(root, p!!.`val`, q!!.`val`)
        return TreeNode(common)
    }

    fun traverse(root: TreeNode?, p: Int, q: Int): Boolean {
        if(root == null) return false
        val leftContains = traverse(root.left, p, q)
        val rightContains = traverse(root.right, p, q)
        val contains = root.`val` == p || root.`val` == q
        if((leftContains && rightContains) || (leftContains && contains) || (rightContains && contains)) {
            common = root.`val`
            return true
        }
        return contains || leftContains || rightContains
    }
}

fun main() {
    Solution().lowestCommonAncestor(
        TreeNode(3).apply {
            left = TreeNode(5)
            right = TreeNode(1)
        },
        TreeNode(5),
        TreeNode(1)
    ).also {
        println(it!!.`val`)
    }
}