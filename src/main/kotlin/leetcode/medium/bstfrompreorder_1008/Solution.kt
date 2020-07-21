package leetcode.medium.bstfrompreorder_1008

import leetcode.easy.mergetwobinarytrees_617.TreeNode

class Solution {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        return construct(preorder)
    }

    fun construct(preorder: IntArray): TreeNode? {
        if(preorder.isEmpty()) return null
        val node = TreeNode(preorder[0])
        if(preorder.size == 1) return node
        val r = preorder.indexOfGreater(preorder[0])
        node.left = construct(preorder.copyOfRange(1, r))
        node.right = construct(preorder.copyOfRange(r, preorder.size))
        return node
    }

    fun IntArray.indexOfGreater(n: Int): Int {
        for(i in indices) {
            if(this[i] > n) {
                return i
            }
        }
        return size
    }
}

fun main() {
    Solution().bstFromPreorder(intArrayOf(8,5,1,7,10,12)).also { it?.log("root") }
    Solution().bstFromPreorder(intArrayOf(4,2)).also { it?.log("root") }
}