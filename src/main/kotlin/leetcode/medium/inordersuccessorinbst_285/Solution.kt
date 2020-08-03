package leetcode.medium.inordersuccessorinbst_285

import leetcode.easy.mergetwobinarytrees_617.TreeNode

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    /*
    traverse in order l, root, r
    when i find p
    ans is next step
    */
    private var ans: TreeNode? = null
    fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
        if(root == null || p == null) return null
        traverse(root, p, false)
        return ans
    }

    private fun traverse(root: TreeNode?, p: TreeNode, found: Boolean): Boolean {
        if(root == null) return false

        val foundLeft = traverse(root.left, p, found)
        var f = root.`val` == p.`val`
        if((foundLeft || found ) && ans == null) {
            ans = TreeNode(root.`val`)
            return true
        }
        val foundRight = traverse(root.right, p, f)
        return f || foundLeft || foundRight || found
    }
}

fun main() {
    Solution().inorderSuccessor(TreeNode(2).apply {
        left = TreeNode(1)
        right = TreeNode(3)
    }, TreeNode(1)).also {
        println(it?.`val`)
    }
}