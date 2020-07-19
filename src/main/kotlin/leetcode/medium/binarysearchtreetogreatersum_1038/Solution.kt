package leetcode.medium.binarysearchtreetogreatersum_1038

import leetcode.easy.mergetwobinarytrees_617.TreeNode

// same as easy 538
class Solution {
    fun bstToGst(root: TreeNode?): TreeNode? {
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
    Solution().bstToGst(
        TreeNode(5).apply {
            left = TreeNode(2)
            right = TreeNode(13)
        }
    )?.log()
}