package leetcode.medium.validatebinsearchtree_98

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

    data class Item(
        val node: TreeNode,
        val isLeft: Boolean
    )

    private var ans = true
    fun isValidBST(root: TreeNode?): Boolean {
        if(root == null) return true
        preorder(root.left, listOf(Item(root, true)))
        preorder(root.right, listOf(Item(root, false)))
        return ans
    }

    private fun preorder(node: TreeNode?, items: List<Item>) {
        if(node == null) return
        if(!items.validate(node.`val`)) {
            ans = false
            return
        }
        var mutableItems = items.toMutableList()
        mutableItems.add(Item(node, true))
        preorder(node.left, mutableItems)

        mutableItems = items.toMutableList()
        mutableItems.add(Item(node, false))
        preorder(node.right, mutableItems)
    }

    private fun List<Item>.validate(value: Int): Boolean {
        forEach { item ->
            val v = item.node.`val`
            if(item.isLeft) {
                if(v <= value) return false
            } else {
                if(v >= value) return false
            }
        }
        return true
    }
}