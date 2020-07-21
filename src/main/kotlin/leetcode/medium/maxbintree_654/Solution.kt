package leetcode.medium.maxbintree_654

import leetcode.easy.mergetwobinarytrees_617.TreeNode

class Solution {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        if(nums.isEmpty()) return null
        val max = nums.max()!!
        val node = TreeNode(max)
        val midIndex = nums.indexOf(max)
        val leftArr = nums.slice(0 until midIndex)
        val rightArr = nums.slice(midIndex + 1 until nums.size)
        node.left = constructMaximumBinaryTree(leftArr.toIntArray())
        node.right = constructMaximumBinaryTree(rightArr.toIntArray())
        return node
    }
}

fun main() {
    Solution().constructMaximumBinaryTree(intArrayOf(3,2,1,6,0,5)).also {
        it?.log("root")
    }
}