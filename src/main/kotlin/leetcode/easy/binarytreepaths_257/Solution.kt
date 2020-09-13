package leetcode.easy.binarytreepaths_257

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
    private val list = mutableListOf<String>()
    fun binaryTreePaths(root: TreeNode?): List<String> {
        if(root == null) return emptyList()
        dfs(root, "")
        return list
    }

    private fun dfs(node: TreeNode?, s: String) {
        if(node == null) return
        val newS = if(s.isEmpty()) "${node.`val`}" else "$s->${node.`val`}"
        if(node.left == null && node.right == null) {
            list.add(newS)
            return
        }
        dfs(node.left, newS)
        dfs(node.right, newS)
    }
}