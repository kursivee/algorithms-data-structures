package leetcode.medium.maxbintree_654

import leetcode.easy.mergetwobinarytrees_617.TreeNode

class Solution {
    fun constructMaximumBinaryTree2(nums: IntArray): TreeNode? {
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

    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return construct(nums, 0, nums.size)
    }

    fun construct(nums: IntArray, l: Int, r: Int): TreeNode? {
        if(l == r) return null
        val midIndex = nums.maxIndex(l, r)
        val node = TreeNode(nums[midIndex])
        node.left = construct(nums, l, midIndex - 1)
        node.right = construct(nums, midIndex + 1, r)
        return node
    }

    fun IntArray.maxIndex(l: Int, r: Int): Int {
        var largest = this[l]
        var index = l
        for(i in l until r) {
            if(this[i] > largest) {
                index = i
                largest = this[i]
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