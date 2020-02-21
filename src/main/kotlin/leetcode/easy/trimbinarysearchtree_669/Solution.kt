package leetcode.easy.trimbinarysearchtree_669

import leetcode.easy.mergetwobinarytrees_617.TreeNode
import leetcode.easy.mergetwobinarytrees_617.log

// https://leetcode.com/problems/trim-a-binary-search-tree/
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
    fun trimBST(root: TreeNode?, L: Int, R: Int): TreeNode? {
        if(root == null) return null
        return filterTree(root, L, R)
    }

    private fun filterTree(root: TreeNode, L: Int, R: Int): TreeNode? {
        var node: TreeNode? = null
        if(root.`val` in L..R) {
            node = root
        }
        root.right?.let {
            val n = filterTree(it, L, R)
            if(node == null)
                node = n
            else node!!.right = n
        }
        (node ?: root).left?.let {
            val n = filterTree(it, L, R)
            if(node == null)
                node = n
            else node!!.left = n
        }
        return node
    }
}

fun main() {
    Solution().trimBST(TreeNode(1).apply {
        left = TreeNode(0)
        right = TreeNode(2)
    }, 1, 2).also {
        log(it!!)
    }

    Solution().trimBST(TreeNode(3).apply {
        left = TreeNode(0).apply {
            right = TreeNode(2).apply {
                left = TreeNode(1)
            }
        }
        right = TreeNode(4)
    }, 1, 3).also {
        log(it!!)
    }

    Solution().trimBST(TreeNode(41).apply {
        left = TreeNode(37).apply {
            left = TreeNode(24).apply {
                right = TreeNode(35).apply {
                    left = TreeNode(30)
                }
            }
            right = TreeNode(39).apply {
                left = TreeNode(38)
                right = TreeNode(40)
            }
        }
        right = TreeNode(44).apply {
            left = TreeNode(42)
            right = TreeNode(48)
        }
    }, 25, 55).also {
        log(it!!)
    }

    Solution().trimBST(TreeNode(3).apply {
        left = TreeNode(1).apply {
            right = TreeNode(2)
        }
        right = TreeNode(4)
    }, 1, 2).also {
        log(it ?: TreeNode(-1))
    }
}