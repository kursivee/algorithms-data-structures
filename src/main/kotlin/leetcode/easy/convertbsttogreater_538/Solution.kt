package leetcode.easy.convertbsttogreater_538

import leetcode.easy.mergetwobinarytrees_617.TreeNode

// same as medium 1038
class Solution {
    fun convertBST(root: TreeNode?): TreeNode? {
        traverse(root, 0)
        return root
    }

    fun traverse(root: TreeNode?, n: Int): Int {
        if(root == null) return n
        val sumRight = traverse(root.right, n)
        root.`val` += sumRight
        return traverse(root.left, root.`val`)
    }
}

fun main() {
    Solution().convertBST(
        TreeNode(5).apply {
            left = TreeNode(2)
            right = TreeNode(13)
        }
    )?.log()
}