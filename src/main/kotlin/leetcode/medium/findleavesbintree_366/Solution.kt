package leetcode.medium.findleavesbintree_366

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
    val ignored = mutableListOf<Int>()
    fun findLeaves(root: TreeNode?): List<List<Int>> {
        if(root == null) return emptyList()
        var i = 0
        val list = mutableListOf<MutableList<Int>>()
        while(dfs(root, null)) {
            val sub = mutableListOf<Int>()
            for(j in i until ignored.size) {
                sub.add(ignored[j])
            }
            i = ignored.size
            list.add(sub)
        }
        val sub = mutableListOf<Int>()
        for(j in i until ignored.size) {
            sub.add(ignored[j])
        }
        i = ignored.size
        list.add(sub)
        return list
    }

    fun dfs(root: TreeNode?, parent: TreeNode?): Boolean {
        if(root == null) return false
        if(root.left == null && root.right == null) {
            if(parent?.left == root) {
                parent?.left = null
            } else {
                parent?.right = null
            }
            ignored.add(root.`val`)
            return false
        }
        dfs(root.left, root)
        dfs(root.right, root)
        return true
    }
}

fun main() {
    Solution().findLeaves(TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    })
}