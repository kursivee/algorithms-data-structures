package leetcode.medium.maxbintree_654

import leetcode.easy.mergetwobinarytrees_617.TreeNode

class Solution {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        if(nums.isEmpty()) return null
        val midIndex = nums.maxIndex()
        val max = nums[midIndex]
        val node = TreeNode(max)
        val leftArr = nums.copyOfRange(0, midIndex)
        val rightArr = nums.copyOfRange(midIndex + 1, nums.size)
        node.left = constructMaximumBinaryTree(leftArr)
        node.right = constructMaximumBinaryTree(rightArr)
        return node
    }

    fun IntArray.maxIndex(): Int {
        var max = this[0]
        var index = 0
        for(i in 1 until size) {
            if(this[i] > max) {
                max = this[i]
                index = i
            }
        }
        return index
    }
}

fun main() {
    Solution().constructMaximumBinaryTree(intArrayOf(3,2,1,6,0,5)).also {
        it?.log("root")
    }
}