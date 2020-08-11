package leetcode.medium.insertintobst_701

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
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if(root == null) return TreeNode(`val`)
        preorder(root, null, `val`)
        return root
    }

    private fun preorder(curr: TreeNode?, prev: TreeNode?, target: Int) {
        if(curr == null) {
            if(prev != null) {
                if(prev.`val` < target) {
                    prev.right = TreeNode(target)
                } else {
                    prev.left = TreeNode(target)
                }
            }
            return
        }

        if(target < curr.`val`) {
            preorder(curr.left, curr, target)
        } else {
            preorder(curr.right, curr, target)
        }
    }
}