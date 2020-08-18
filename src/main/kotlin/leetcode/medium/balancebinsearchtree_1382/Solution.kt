package leetcode.medium.balancebinsearchtree_1382

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
    Tag: Tree Traversal
    Intuition:
    Break down the tree with inorder traversal. This will give you you the elements in order.
    From there we can construct a bin tree by using the binary search method.
    Grab the middle element of the list for the root node. Then process
    the all elements to the left, then right.

    Time Complexity O(n)
    Space Complexity O(n)
    */
    fun balanceBST(root: TreeNode?): TreeNode? {
        val list = inorder(root, mutableListOf())
        return buildTree(list, 0, list.size - 1)
    }

    private fun buildTree(list: List<Int>, l: Int, r: Int): TreeNode? {
        if(l > r) return null
        val mid = l + (r - l) / 2
        val node = TreeNode(list[mid])
        node.left = buildTree(list, l, mid - 1)
        node.right = buildTree(list, mid + 1, r)
        return node
    }

    private fun inorder(node: TreeNode?, list: MutableList<Int>): List<Int> {
        if(node == null) return mutableListOf()
        inorder(node.left, list)
        list.add(node.`val`)
        inorder(node.right, list)
        return list
    }
}