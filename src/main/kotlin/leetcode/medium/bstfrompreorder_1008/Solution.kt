package leetcode.medium.bstfrompreorder_1008

import leetcode.easy.mergetwobinarytrees_617.TreeNode

class Solution {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        val list = preorder.toMutableList()
        return construct(list)
    }

    fun construct(preorder: MutableList<Int>): TreeNode? {
        if(preorder.isEmpty()) return null
        val node = TreeNode(preorder[0])
        if(preorder.size == 1) return node
        var rightIndex = preorder.indexOfGreater(node.`val`)
        val l = preorder.subList(1, rightIndex)
        val r = preorder.subList(rightIndex, preorder.size)
        node.left = construct(l)
        node.right = construct(r)
        return node
    }

    fun List<Int>.indexOfGreater(n: Int): Int {
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