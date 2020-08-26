package leetcode.easy.constructstringfrombintree_606

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
    fun tree2str(t: TreeNode?): String {
        if(t == null) return ""
        return preorder(t, true)
    }

    private fun preorder(node: TreeNode?, isRoot: Boolean): String {
        if(node == null) return "()"
        var s = if(isRoot) "" else "("
        s += "${node.`val`}"
        val l = preorder(node.left, false)
        val r = preorder(node.right, false)
        if(r != "()") s += "$l$r"
        else if(l != "()") s += "$l"
        s += if(isRoot) "" else ")"
        return s
    }
}