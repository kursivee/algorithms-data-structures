package leetcode.easy.searchbst_700

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
class Solution {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if(root == null) { return null }
        return when {
            root.`val` == `val` -> {
                root
            }
            `val` < root.`val` -> {
                searchBST(root.left, `val`)
            }
            else -> {
                searchBST(root.right, `val`)
            }
        }

        /**
         * NOTE: if/else performs faster
        return if(root.`val` == `val`) {
        root
        } else if(`val` < root.`val`) {
        searchBST(root.left, `val`)
        } else {
        searchBST(root.right, `val`)
        }
         */
    }
}

fun main() {
    val node = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        right = TreeNode(7)
    }
    Solution().searchBST(node, 2)?.also { log(it) }
}