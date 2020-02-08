package leetcode.easy.increaseordersearchtree_897

import leetcode.easy.mergetwobinarytrees_617.TreeNode
import leetcode.easy.mergetwobinarytrees_617.log

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
// https://leetcode.com/problems/increasing-order-search-tree/
class Solution {

    private var ans: TreeNode? = null
    private var currNode: TreeNode? = null

    fun increasingBST(root: TreeNode?): TreeNode? {
        if(root == null) {
            return null
        }
        bst(root)
        return ans
    }

    fun bst(root: TreeNode?) {
        if(root == null) return
        bst(root.left)
        ans?.add(root.`val`) ?: run {
            ans = TreeNode(root.`val`)
            currNode = ans
        }
        bst(root.right)
    }

    fun TreeNode.add(i: Int) {
        currNode!!.right = TreeNode(i)
        currNode = currNode!!.right!!
    }
}

fun main() {
    Solution().increasingBST(TreeNode(2).apply {
        left = TreeNode(1)
        right = TreeNode(3)
    }).also {
        log(it!!)
    }
}