package leetcode.easy.findallthelonelynodes_1469

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
    no siblings
    root, left, right
    add the child if left xor right
    traverse left
    traverse right
    */
    private val list = mutableListOf<Int>()

    fun getLonelyNodes(root: TreeNode?): List<Int> {
        if(root == null) return emptyList()
        traverse(root, false)
        return list
    }

    private fun traverse(node: TreeNode?, isAlone: Boolean) {
        if(node == null) return
        if(isAlone) {
            list.add(node.`val`)
        }
        if(node.left == null && node.right == null) return
        if((node.left == null) xor (node.right == null)) {
            traverse(node.left, true)
            traverse(node.right, true)
            return
        }
        traverse(node.left, false)
        traverse(node.right, false)
    }
}